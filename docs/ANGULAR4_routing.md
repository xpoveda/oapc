
Routing y componentes
=====================

Para crear una pagina en angular hay que entender que funciona con componentes.

El componente principal de Angular es "app" que se instalará automaticamente cuando 
creemos un nuevo proyecto.

Este componente se ejecutará a cada peticion y seria el index.html de otras aplicaciones como
wordpress o prestashop donde se recogen los parametros y se traspasan a los controladores para hacer una cosa u otra.
Es decir, realmente siempre se llama al index pero es angular quien lo enruta.

Los ficheros que tendremos en nuestro ejemplo seran los siguientes:
- app.component.html
- app.component.ts
- app.module.ts
- app.routing.module.ts

*app.module.ts*
```
import { NgModule }                    from '@angular/core';
import { BrowserModule }               from '@angular/platform-browser';
import { FormsModule }                 from '@angular/forms';
import { HttpClientModule }            from '@angular/common/http';

import { AppComponent }                from './app.component';
import { AppRoutingModule }            from './app-routing.module';

import { HeaderComponent }             from './header/header.component';
import { FooterComponent }             from './footer/footer.component';

import { Dummie1Component }            from './dummie1/dummie1.component';
import { Dummie2Component }            from './dummie2/dummie2.component';

import { PaginaPrincipalComponent }    from './pagina-principal/pagina-principal.component';
import { PaginaNoEncontradaComponent } from './pagina-no-encontrada/pagina-no-encontrada.component';

@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    Dummie1Component,
    Dummie2Component,
    PaginaPrincipalComponent,
    PaginaNoEncontradaComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```

*app.component.ts*
```
import { Component }       from '@angular/core';
import { BrowserModule }   from '@angular/platform-browser';

import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls:  ['./app.component.css']
})
export class AppComponent {
  titulo  = 'Siempre llamamos a AppComponent';
  titulo2 = `Ponemos los selectores app-header y app-footer`; 
}
```

*app.component.html*
```
<app-header></app-header>
<app-footer></app-footer>
```

*app-routing.module.ts*
```
import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { Dummie1Component }            from './dummie1/dummie1.component';
import { Dummie2Component }            from './dummie2/dummie2.component';
import { PaginaPrincipalComponent }    from './pagina-principal/pagina-principal.component';
import { PaginaNoEncontradaComponent } from './pagina-no-encontrada/pagina-no-encontrada.component';

const routes: Routes = [
  { path: '',           component: PaginaPrincipalComponent },
  { path: 'dummie1',    component: Dummie1Component },
  { path: 'dummie2',    component: Dummie2Component },
  { path: '**',         component: PaginaNoEncontradaComponent },  
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
```

Las diferentes paginas a las que llamaremos con realmente componentes.
El componente que siempre se llamará sera `app`.

De esta forma podemos crear con angular cli un componente con el que se crearan automaticamente los ficheros y realizará los imports.

Aqui lo que hemos hecho es generar componentes "header", "footer" y "dummie1" para ver como diferente componentes podrian delegar 
las funcionalidades de las distintas paginas.

```
ng generate component header
ng generate component footer
ng generate component Dummie1
ng generate component Dummie2
ng generate component PaginaPrincipal
ng generate component PaginaNoEncontrada
```

Y en *header.component.html* tendriamos:
Es importante ese router-outlet porque sino al hacer un click sobre los distintos elementos del menu no saltariamos hacia ellos.
```
<h1>{{title}}</h1>
<nav>
  <a routerLink="/">Principal</a>
  <a routerLink="/dummie1">Dummie1</a>
  <a routerLink="/dummie2">Dummie2</a>  >
</nav>
<router-outlet></router-outlet>
```

*paginaprincipal.component.html*
```
<p>PAGINA PRINCIPAL</p>
```

*paginanoencontrada.component.html*
```
<p>PAGINA NO ENCONTRADA</p>
```


*dummie.component.ts* 

En este caso lo que hemo hecho es pasar directamente un `template` no un `template-url`.

```
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dummie1',
  template: `<p> DUMMIE1 CONTENEDOR </p>
  `,
  styleUrls: ['./dummie1.component.css']
})
export class Dummie1Component implements OnInit {

  titulo;

  constructor() { }

  ngOnInit() {
     this.titulo = "VARIABLE CARGADA ngOnInit"
  }
}
```


Finalmente aqui tenemos la interaccion:

```
http://localhost:4200
Principal Dummie1 Dummie2
PAGINA PRINCIPAL
footer works!

http://localhost:4200/dummie1
Principal Dummie1 Dummie2
DUMMIE1 CONTENEDOR
footer works!

http://localhost:4200/dummie11
Principal Dummie1 Dummie2
PAGINA NO ENCONTRADA
footer works!
```
