Acceso desde angular contra nuestra API basada en token y localstorage (no cookies)
===================================================================================

Para probar en desarrollo hemos de activar el proxy de angular para que el navegador no nos corte la llamada por "CORS".

```
https://juristr.com/blog/2016/11/configure-proxy-api-angular-cli/
```

Para ello hemos de modificar el `package.json` añadiendo un `"start": "ng serve --proxy-config proxy.conf.json"` y en el fichero
de configuracion del proxy poner

```
{
    "/api": {
    "target": "http://localhost:8080",
    "secure": false
    }
}
```

Si no se hace esto con `postman`, que es una herramiento al fin y al cabo funciona, pero con navegador no.

Bueno documento en el que se explica esta problematica del CORS y ademas se comenta como hacer que nuestro API REST de springboot pueda 
aceptar distintos origenes y no se tenga que habilitar el acceso via proxy.
```
https://chariotsolutions.com/blog/post/angular-2-spring-boot-jwt-cors_part1/
https://chariotsolutions.com/blog/post/angular-2-spring-boot-jwt-cors_part2/
```

Starters principales:
```
https://github.com/bfwg/springboot-jwt-starter
https://github.com/bfwg/angular-spring-starter
```

modulo principal
```
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```

componente principal
```
import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {


  title = 'app';
  results = '';

  mybody;
  myoptions;
  mydata;

  constructor(private http: HttpClient){
  }
  ngOnInit(): void {

    /////////////////////////////////////////////////////////////
    ///// Acceso a API sin autentificacion

    // https://medium.com/codingthesmartway-com-blog/angular-4-3-httpclient-accessing-rest-web-services-with-angular-2305b8fd654b

    /*
    this.mybody    = { "title":"hola", "content":"contenido" };
    this.myoptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };

    this.http.post('/api/notes', this.mybody, this.myoptions)
      .subscribe(data => {
      this.mydata = data;
      console.log(this.mydata);
      }
    );

    this.http.get('/api/notes')
      .subscribe(data => {
      this.mydata = data;
      console.log(this.mydata);
      }
    );
    */

    /////////////////////////////////////////////////////////////

    if (!localStorage.getItem('tk'))
    {  
      console.log("Usuario no autentificado, nos autentificamos..");

      this.mybody     = { "username" : "admin", "password" : "123" };
      this.myoptions  = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };

      this.http.post <MyTokenResponse> ('/api/login', this.mybody, this.myoptions)
        .subscribe(data => { 
          this.mydata = data;

          console.log("/api/login");
          localStorage.setItem('tk', this.mydata.access_token);
          console.log("token generado: " + localStorage.getItem('tk'));        
        } );
    }
    else  
    {
      console.log("Usuario ya autentificado");
      console.log("token utilizado: " + localStorage.getItem('tk'));        
    }
          
    ////////////////////////////////////////////////////////////                        

    if (localStorage.getItem('tk'))
    {
      this.myoptions    = { headers: new HttpHeaders (
        { 'Content-Type' : 'application/json' , 
          'Authorization': 'Bearer ' + localStorage.getItem('tk') 
        }
      ) };                        

      this.http.get ('/api/whoami', this.myoptions)
        .subscribe(data => {
          this.mydata = data;        

          console.log("/api/whoami");
          console.log(this.mydata);
        } );
    }

    ////////////////////////////////////////////////////////////

    if (localStorage.getItem('tk'))
    {    
      this.myoptions    = { headers: new HttpHeaders (
        { 'Content-Type' : 'application/json' , 
          'Authorization': 'Bearer ' + localStorage.getItem('tk') 
        }
      ) };                        

      this.http.get ('/api/user/all', this.myoptions)
      .subscribe(data => {
        this.mydata = data;        

        console.log("/api/user/all");
        console.log(this.mydata);
      } );
    }

    ////////////////////////////////////////////////////////////    

    if (localStorage.getItem('tk'))
    {  
      this.mybody     = { };

      this.myoptions    = { headers: new HttpHeaders (
        { 'Content-Type' : 'application/json' , 
          'Authorization': 'Bearer ' + localStorage.getItem('tk') 
        }
      ) };                        
      
      this.http.post <MyTokenResponse> ('/api/refresh', this.mybody, this.myoptions)
        .subscribe(data => { 
          this.mydata = data;

          console.log("/api/refresh");
          console.log(this.mydata);
          localStorage.setItem('tk', this.mydata.access_token);
          console.log("nuevo token : " + localStorage.getItem('tk'));                  
        } );
    }

    //////////////////////////////////////////////////////////// 

    /*

    if (localStorage.getItem('tk'))
    {  
      this.mybody     = {"oldPassword" : "flash2009" , "newPassword" : "123" };

      this.myoptions    = { headers: new HttpHeaders (
        { 'Content-Type' : 'application/json' , 
          'Authorization': 'Bearer ' + localStorage.getItem('tk') 
        }
      ) };                        
      
      this.http.post <MyTokenResponse> ('/api/change-password', this.mybody, this.myoptions)
        .subscribe(data => { 
          this.mydata = data;

          console.log("/api/change-password");
          console.log(this.mydata);
        } );

        ////
        this.mybody     = { };

        this.myoptions    = { headers: new HttpHeaders (
          { 'Content-Type' : 'application/json' , 
            'Authorization': 'Bearer ' + localStorage.getItem('tk') 
          }
        ) };                        
        
        this.http.post <MyTokenResponse> ('/api/refresh', this.mybody, this.myoptions)
          .subscribe(data => { 
            this.mydata = data;
  
            console.log("/api/refresh");
            console.log(this.mydata);
            localStorage.setItem('tk', this.mydata.access_token);
            console.log("nuevo token : " + localStorage.getItem('tk'));                  
          } );
    } 

    */
    
    /////////////////////////////////////////////////////////////
    //// Acceso a API REST en internet

    this.http.get('https://jsonplaceholder.typicode.com/posts/')
      .subscribe(data => {
        console.log(data);
      } );    

  }
}

///////////////////////////////////////////////////////////////////////

interface MyTokenResponse {
  access_token: string;
  expires_in:   string;
}
```
