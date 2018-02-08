Integracion de Angular con Bootstrap
====================================

Para que Angular pueda trabajar con Bootstrap la forma mas sencilla de hacerlo es con la libreria `ngx-bootstrap`.
Sin esa libreria podriamos utilizar solo la parte de grid, porque la parte de interaccion con los elementos que nos provee Bootstrap
daria error de javascript.

Mas información en la url *https://valor-software.com/ngx-bootstrap/*

Los distintos objetos de bootstrap (alerts, dropdown,..) se tendran que importar 1 a 1 con un import tal y como se explica más
abajo y tal y como se nos explica en la web.

Es importante remarcar que ngx-bootstrap no tiene soporte para navbar, por lo tanto los menus los tendremos que hacer con otra cosa.

Pero antes de nada procedemos a instalarlo. La forma de instalarla con angular cli y bootstrap 4 se indica aqui.

https://github.com/valor-software/ngx-bootstrap/blob/development/docs/getting-started/bootstrap4.md

Creamos un proyecto desde 0
```
npm i -g @angular/cli
ng new my-app
cd my-app
ng serve
```

Desde es proyecto añadimos las librerias de bootstrap
```
npm install ngx-bootstrap bootstrap@next --save
```

Si se produce algun error tendremos que instalar esto
```
npm install copy-webpack-plugin@4.3.0
```

Y para que funcione perfecto tambien:
```
npm install jquery
npm install popper
```

Modificaremos el fichero `angular-cli.json` añadiendo las css de bootstrap.
```
"styles": [  
 "../node_modules/bootstrap/dist/css/bootstrap.min.css",  
 "styles.css"  
 ],
```

Y para testear que este bien podemos modificar el fichero `src/app/app.module.ts``y ahi:
```
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
...

@NgModule({
   ...
   imports: [BsDropdownModule.forRoot(), ... ],
    ... 
})
```

Y tambien este el template `src/app/app.component.html`
```
<div class="btn-group" dropdown>
  <button dropdownToggle type="button" class="btn btn-primary dropdown-toggle">
    Button dropdown <span class="caret"></span>
  </button>
  <ul *dropdownMenu class="dropdown-menu" role="menu">
    <li role="menuitem"><a class="dropdown-item" href="#">Action</a></li>
    <li role="menuitem"><a class="dropdown-item" href="#">Another action</a></li>
    <li role="menuitem"><a class="dropdown-item" href="#">Something else here</a></li>
    <li class="divider dropdown-divider"></li>
    <li role="menuitem"><a class="dropdown-item" href="#">Separated link</a>
    </li>
  </ul>
</div>
```

A continuacion `ng serve` y un `http://localhost:4200` y ya se verian los cambios.
