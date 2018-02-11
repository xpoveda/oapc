Menu responsive con angular y bootstrap
=======================================

Instalamos la libreria ngx-bootstrap.
Desde un nuevo proyecto creado con `ng new nombreproyecto` hacemos
```
npm install ngx-bootstrap --save
```
En el `index.html` justo antes de acabar el elemento `</head>`
```
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
```

En el fichero `app.module.ts` 
```
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';

import { CollapseModule, BsDropdownModule } from 'ngx-bootstrap';

@NgModule({
  imports:      [ BrowserModule, FormsModule, CollapseModule.forRoot(), BsDropdownModule.forRoot() ],
  declarations: [ AppComponent ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
```

Y en el `app.component.html`
```
<div class="container">
  <nav class="navbar navbar-default">
    <div class="container-fluid">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" (click)="isCollapsed = !isCollapsed" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">Brand</a>
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" [collapse]=isCollapsed>
        <ul class="nav navbar-nav">
          <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
          <li><a href="#">Link</a></li>
          <li class="dropdown" dropdown>
  <a href="#" dropdownToggle class="dropdown-toggle">Dropdown <span class="caret"></span></a>
    <ul *dropdownMenu class="dropdown-menu" role="menu">
      <li role="menuitem"><a class="dropdown-item" href="#">Action</a></li>
      <li role="menuitem"><a class="dropdown-item" href="#">Another action</a></li>
      <li role="menuitem"><a class="dropdown-item" href="#">Something else here</a></li>
      <li class="divider dropdown-divider"></li>
      <li role="menuitem"><a class="dropdown-item" href="#">Separated link</a>
      </li>
    </ul>
  </li>
        </ul>
        <form class="navbar-form navbar-left">
          <div class="form-group">
            <input type="text" class="form-control" placeholder="Search">
          </div>
          <button type="submit" class="btn btn-default">Submit</button>
        </form>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#">Link</a></li>
                <li class="dropdown" dropdown>
  <a href="#" dropdownToggle class="dropdown-toggle">Dropdown <span class="caret"></span></a>
    <ul *dropdownMenu class="dropdown-menu" role="menu">
      <li role="menuitem"><a class="dropdown-item" href="#">Action</a></li>
      <li role="menuitem"><a class="dropdown-item" href="#">Another action</a></li>
      <li role="menuitem"><a class="dropdown-item" href="#">Something else here</a></li>
      <li class="divider dropdown-divider"></li>
      <li role="menuitem"><a class="dropdown-item" href="#">Separated link</a>
      </li>
    </ul>
  </li>
        </ul>
      </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
  </nav>
</div>
```
