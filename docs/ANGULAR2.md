
Visual studio code
==================
Mediante visual studio code podemos trabajar sin problema con angular.

https://code.visualstudio.com/

Importante es habilitar el proxy mediante `Archivo\preferencias\configuracion` y la modificacion a nivel de usuario del `settings.json`
```
{
"http.proxy": "http://USER:PASSWORD@PROXY_URL:PROXY_PORT/",
"https.proxy": "http://USER:PASSWORD@PROXY_URL:PROXY_PORT/",
"http.proxyStrictSSL": false
}
```

Muy util tambien es el terminal integrado mediante `Ver\Terminal integrado`

Elementos a investigar
======================

Routing (navegacion)
--------------------
Tour of heroes example: https://v2.angular.io/docs/ts/latest/tutorial/
Concrete page routing and navigation: https://www.concretepage.com/angular-2/angular-2-routing-and-navigation-example

Localstorage (tratamiento de sesion)
------------------------------------
Serie de 4 videos: http://www.render2web.com/tu-primera-aplicacion-angular-4-bootstrap-4-y-localstorage-parte-1/amp/

Llamadas API mediante Rxjs observers en angular 5
-------------------------------------------------
https://www.metaltoad.com/blog/angular-5-making-api-calls-httpclient-service

i18n (internacionalizacion)
---------------------------
http://www.ngx-translate.com/
https://plnkr.co/edit/WccVZSBM0rUgq2sXSUbe?p=preview

Trabajando con angular cli
==========================
Con `angular cli` podemos crear una nueva aplicacion a la que accederemos con `http://localhost:4200`.
El servidor liviano que utiliza nos permitira ver los cambios simplemente con grabar el fuente ya que se desplegará automaticamente.
```
ng new my-app
cd my-app
ng serve -o
```

Si partimos de un proyecto de github haremos los siguientes pasos.
Esto lo que hará es añadir los ficheros de la carpeta `node modules` y los que falten
```
copia del proyecto
npm install
ng build
```

Tambien podemos utilizar un proyecto que tengamos dummie y copiar solamente la carpeta `src`.
Despues de eso hacer un `ng serve -o`.


Subiendo angular a produccion
=============================
Si queremos realizar la subida a produccion a `APACHE` lo que haremos es un `ng build -prod` que generará los ficheros minificados en la carpeta `dist`.
Esos ficheros seran los unicos que tengamos que subir a la carpeta raiz del apache `htdocs` o `/var/www/html/` segun toque.

Es importante remarcar que ademas hemos de crear el fichero `.htaccess` (asegurandonos que tiene permisos) y con el siguiente contenido.
Esto lo que hace es asegurarnos que todas las llamadas referencian al index.html que es el que enruta las llamadas mediante el routing
propio de angular.
```
<IfModule mod_rewrite.c>
    RewriteEngine on

    # Don't rewrite files or directories
    RewriteCond %{REQUEST_FILENAME} -f [OR]
    RewriteCond %{REQUEST_FILENAME} -d
    RewriteRule ^ - [L]

    # Rewrite everything else to index.html
    # to allow html5 state links
    RewriteRule ^ index.html [L]
</IfModule>
```

Subido a un servidor de produccion de digital ocean y funciona sin problema.
Tambien probado en xampp y correcto.
