Si estamos bajo proxy corporativo hemos de habilitarlo
```
npm config set proxy=http://USER:PASSWORD@PROXY_URL:PROXY_PORT
npm config set https-proxy=http://USER:PASSWORD@PROXY_URL:PROXY_PORT
npm config list
```
Instalamos la ultima version de angular cli.
Es necesario tambien que hayamos instalado node.js y npm.

https://angular.io/guide/quickstart

```
C:\angular>npm install -g @angular/cli

C:\angular>ng --version

    _                      _                 ____ _     ___
   / \   _ __   __ _ _   _| | __ _ _ __     / ___| |   |_ _|
  / ? \ | '_ \ / _` | | | | |/ _` | '__|   | |   | |    | |
 / ___ \| | | | (_| | |_| | | (_| | |      | |___| |___ | |
/_/   \_\_| |_|\__, |\__,_|_|\__,_|_|       \____|_____|___|
               |___/

Angular CLI: 1.6.7
Node: 9.4.0
OS: win32 x64
Angular:
```

Creamos el cuerpo de la nueva aplicacion
```
C:\angular>ng new my-app
  create my-app/e2e/app.e2e-spec.ts (288 bytes)
  create my-app/e2e/app.po.ts (208 bytes)
  create my-app/e2e/tsconfig.e2e.json (235 bytes)
  create my-app/karma.conf.js (923 bytes)
  create my-app/package.json (1290 bytes)
  create my-app/protractor.conf.js (722 bytes)
  create my-app/README.md (1021 bytes)
  create my-app/tsconfig.json (363 bytes)
  create my-app/tslint.json (3012 bytes)
  create my-app/.angular-cli.json (1241 bytes)
  create my-app/.editorconfig (245 bytes)
  create my-app/.gitignore (529 bytes)
  create my-app/src/assets/.gitkeep (0 bytes)
  create my-app/src/environments/environment.prod.ts (51 bytes)
  create my-app/src/environments/environment.ts (387 bytes)
  create my-app/src/favicon.ico (5430 bytes)
  create my-app/src/index.html (292 bytes)
  create my-app/src/main.ts (370 bytes)
  create my-app/src/polyfills.ts (2405 bytes)
  create my-app/src/styles.css (80 bytes)
  create my-app/src/test.ts (642 bytes)
  create my-app/src/tsconfig.app.json (211 bytes)
  create my-app/src/tsconfig.spec.json (283 bytes)
  create my-app/src/typings.d.ts (104 bytes)
  create my-app/src/app/app.module.ts (316 bytes)
  create my-app/src/app/app.component.html (1141 bytes)
  create my-app/src/app/app.component.spec.ts (986 bytes)
  create my-app/src/app/app.component.ts (207 bytes)
  create my-app/src/app/app.component.css (0 bytes)
Installing packages for tooling via npm.
npm WARN deprecated nodemailer@2.7.2: All versions below 4.0.1 of Nodemailer are deprecated. See https://nodemailer.com/status/
npm WARN deprecated node-uuid@1.4.8: Use uuid module instead

> uws@0.14.5 install C:\angular\my-app\node_modules\uws
> node-gyp rebuild > build_log.txt 2>&1 || exit 0


> node-sass@4.7.2 install C:\angular\my-app\node_modules\node-sass
> node scripts/install.js

Cached binary found at C:\Users\USER\AppData\Roaming\npm-cache\node-sass\4.7.2\win32-x64-59_binding.node

> uglifyjs-webpack-plugin@0.4.6 postinstall C:\angular\my-app\node_modules\webpack\node_modules\uglifyjs-webpack-plugin
> node lib/post_install.js


> node-sass@4.7.2 postinstall C:\angular\my-app\node_modules\node-sass
> node scripts/build.js

Binary found at C:\angular\my-app\node_modules\node-sass\vendor\win32-x64-59\binding.node
Testing binary
Binary is fine
npm WARN optional SKIPPING OPTIONAL DEPENDENCY: fsevents@1.1.3 (node_modules\fsevents):
npm WARN notsup SKIPPING OPTIONAL DEPENDENCY: Unsupported platform for fsevents@1.1.3: wanted {"os":"darwin","arch":"any"} (current: {"os":"win32","arch":"x

added 1454 packages in 363.238s
Installed packages for tooling via npm.
Successfully initialized git.
Project 'my-app' successfully created.
```

La ejecutamos en el servidor
```
C:\angular\my-app>ng serve --open
** NG Live Development Server is listening on localhost:4200, open your browser on http://localhost:4200/ **
 10% building modules 8/10 modules 2 active ...lse}!C:\angular\my-app\src\styles.csswebpack: wait until bundle finished: /
Date: 2018-02-05T16:59:52.385Z
Hash: 8abccc9d8981f55bb09c
Time: 12698ms
chunk {inline} inline.bundle.js (inline) 5.79 kB [entry] [rendered]
chunk {main} main.bundle.js (main) 19.3 kB [initial] [rendered]
chunk {polyfills} polyfills.bundle.js (polyfills) 549 kB [initial] [rendered]
chunk {styles} styles.bundle.js (styles) 33.6 kB [initial] [rendered]
chunk {vendor} vendor.bundle.js (vendor) 7.41 MB [initial] [rendered]

webpack: Compiled successfully.
```

Accedemos a ella via navegador o curl con `http:/localhost:4200`

ENJOY!!
