API CRUD RESTful SPRING BOOT CON ACCESO JPA A MYSQL, STREAMS Y PROGRAMACION FUNCIONAL
=====================================================================================

El ejemplo del que partimos esta aqui
```
https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/
```
Lo modificamos para crear en MYSQL (CXAMP, DBEARER) la tabla `Notes` dentro de una BBDD a la que llamaremos `notes` que será accedida por el 
usuario `notes` y sin password.

La tabla se creará automaticamente si no existia cuando levantemos el servidor.

*application.properties*
```
## Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.url = jdbc:mysql://192.168.64.2:3306/notes
spring.datasource.username = notes
spring.datasource.password = 

## Hibernate Properties
# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update
```

*NoteController.java*

En esta parte hemos añadido `programacion funcional` para trabajar con los `streams`.
Los streams son muy optimos, podemos aplicar un offset y un limite (que usaremos para definir las paginaciones de forma facil), 
funciones de mapeo (transformacion) o de filtrado y tambien se les puede aplicar objetos de tipo coleccion.

Programación clara y concisa, eso es la programacion funcional.

Importante que los streams se han de definir como transaccionales y de solo lectura por lo tanto solo aplicaran sobre API get.

```java
package com.example.easynotes.controller;

import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

import javax.validation.Valid;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteRepository noteRepository;
    
    // Los streams se han de definir como transaccionales de solo lectura
    @Transactional(readOnly = true)
    @GetMapping("/notes")
    public List<Note> getAllNotes() {
    	
    		Stream<Note> s = noteRepository.findAllStream();
    		
    		//DOC
    		//http://www.deadcoderising.com/2017-02-21-java-8-accumulate-your-streams-using-collectors/
    	
    		return s
    			// Nos quedamos solo con el titulo de los objetos
        		//.map(x -> x.getTitle())
    			// Nos quedamos con los objetos que cumplen una propiedad, si no es cierta devolvemos null 			
        		//.map(x -> { if (x.getTitle().equals("mi cuarta nota")) return x; else return null; })
    			// Filtramos los null
        		//.filter(x -> x != null)
        		// Nos saltamos n elementos, skip corresponderia a la funcionalidad de offset
        		// .skip(1)
        		// Limitamos el numero de registros a un limite
        		//.limit(2)
    			// Contamos
    			//.count();
        		// Convertimos el stream en una lista
        		.collect(Collectors.toList());
    }
    
    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable(value = "id") Long noteId) {
        Note note = noteRepository.findOne(noteId);
        if(note == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(note);
    }

    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note) {
        return noteRepository.save(note);
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable(value = "id") Long noteId,
                                           @Valid @RequestBody Note noteDetails) {
        Note note = noteRepository.findOne(noteId);
        if(note == null) {
            return ResponseEntity.notFound().build();
        }
        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updatedNote = noteRepository.save(note);
        return ResponseEntity.ok(updatedNote);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable(value = "id") Long noteId) {
        Note note = noteRepository.findOne(noteId);
        if(note == null) {
            return ResponseEntity.notFound().build();
        }

        noteRepository.delete(note);
        return ResponseEntity.ok().build();
    }
}
```

En esta pagina se explica todo lo **IMPORTANTE** que hay que saber sobre `JPA`.

```
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
```

En este caso jugamos con distintos tipos de colecciones y anotamos las querys con JPA el decorador @Query.

*NoteRepository.java
```java
package com.example.easynotes.repository;

import com.example.easynotes.model.Note;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NoteRepository extends JpaRepository<Note, Long> {
	
	@Query("select n from Note n")
	List<Note> findAllList();
	
	@Query("select n from Note n")
	Stream<Note> findAllStream();
	
	@Query("select n from Note n where id = ?1")
	Note findById(Long id);
}
```

Simple clase POJO llamada Note que se mapeara en la tabla notes.

*Note.java*
```java
package com.example.easynotes.model;

import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;

@Entity
@Table(name = "notes")
public class Note{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
```

Con `postman` realizamos las pruebas. Tambien lo podemos hacer con `curl`

```shell
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/api/notes; echo ""
HTTP/1.1 200 
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Thu, 15 Feb 2018 01:13:34 GMT

[{"id":1,"title":"primero","content":"PRIMERO"},{"id":2,"title":"segundo","content":"SEGUNDO"},{"id":3,"title":"tercero","content":"TERCERO"}]


curl -i -H "Content-Type: application/json" -X POST -d '{"title":"sexto","content":"SEXTO"}' http://localhost:8080/api/notes; echo ""
HTTP/1.1 200 
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Thu, 15 Feb 2018 01:26:25 GMT

{"id":6,"title":"sexto","content":"SEXTO"}
```
