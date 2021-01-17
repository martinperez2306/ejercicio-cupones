# ejercicio-cupones

Este repositorio contiene la resolucion del Ejercicio Cupones.

Consta de 3 proyectos Maven

### Cupones

Proyecto CORE de Cupones, contiene  el Modelo de Datos de Cupón y las funcionalidades basicas requeridas.

### Cupones  APIREST

Aplicacion de Spring Boot que responde a los servicios correspondientes.

### Items API Client

Cliente HTTP que consume la API de Items.

## Instrucciones

Se proveen algunos script en bash para facilitar el uso de la API.
- Para buildear la aplicacion de Spring Boot correr el script ```buildAPI.sh```. El Jar resultante se guardara en la carpeta coupons-apirest/target/coupons-apirest-0.0.1.jar.
- Para ejecutar las pruebas automaticas correr ```runTest.sh```. Esto correra el conjunto de Test con Maven.
- Para levantar una instancia local de la API utilizar ```startup.sh```. Con el se buildeará el proyecto y lo levantara por default en el puerto 8080.

## Configuracion (opcional)

Es posible editar algunas configuraciones de la API REST editando el archivo de configuracion ```application.properties``` o estableciendo Variables de Entorno
- PUERTO -> Por default el puerto que escucha la API es 8080. Este puede modificarse cambiando la variable ```server.port``` en el archivo de properties o bien estableciendo la variable de entorno ```SERVER_PORT```.
- REPOSITORIO DE ITEMS -> De forma predeterminada se consume el API de items para recuperar su informacion. Adicionalmente tambien puede configurarse un Mock en memoria con algunos datos dummy. Para esto se debe la propiedad ```repository.items``` o bien mediante la variable de entorno ```REPOSITORY_ITEMS```. Los valores posibles son **http** o **mem**.
- ITEMS API URL -> En caso de utilizar el api de ITEMS debe proverse su URL. Por default ya está establecida.
- CACHE ITEM -> La API de Cupones utiliza un cache para almacenar informacion temporalmente. Mediante la variable ```cache.items.clean.time``` o la variable de entorno ```CACHE_ITEMS_CLEAN_TIME``` se puede especificar la frecuencia con la que el cache se limpiara (en milisegundos).  De forma predeterminada su valor es de 10 minutos.
