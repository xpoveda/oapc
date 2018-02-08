
Directivas ngIf y ngFor en los templates

La forma de pasar informacion de un componente a su template es mediante el operador {{}}.

Muy importante comentar que en angular la comunicacion es bidireccional, tanto del controlador a la vista como al reves.

Ademas tenemos dos directivas muy potentes como son ngIf y ngFor que nos permitiran realizar condicionales y recorridos dentro de los templates.

Mas informacion en: *https://angular.io/guide/displaying-data*

ngIf
====

app.component.ts
```
export class AppComponent {
  nombre = `xavier`; 
}
```

app.component.html
```
  <div *ngIf="nombre=='xavier' else otro_nombre">
      <h1>Hola {{nombre}}</h1>
  </div>

  <ng-template #otro_nombre>
      <h2>Te llamas {{nombre}}</h2>
  </ng-template>
```

ngFor
====

En la clase..
```
heroes = ["superman", "spiderman", "batman"];

```

En el template..
```
  <p>Heroes:</p>
  <ul>
    <li *ngFor="let hero of heroes">
      {{ hero }}
    </li>
  </ul>
```

```
  <div class="row">
      <div class="btn-group" dropdown>
          <button dropdownToggle type="button" class="btn btn-primary dropdown-toggle">
            Botón de los héroes <span class="caret"></span>
          </button>
            <ul *dropdownMenu class="dropdown-menu" role="menu">
              <li role="menuitem" *ngFor="let hero of heroes">
                <a class="dropdown-item" href="#">{{hero}}</a>
              </li>
            </ul>
        </div>        
  </div>
  ```
