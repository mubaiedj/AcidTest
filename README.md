# Desafío Acid Labs

Descripción del desafío.

Desarrollar un servicio proxy de autenticación básico, el cual recibe un nombre de usuario como string(16 caracteres) y una imagen biométrica que representa el rostro del usuario, codificada como un string en BASE64. Este servicio debe recibir ambos parámetros y con esto invocar a otro servicio privado, que decidirá finalmente si la biometría de la imagen proporcionada coincide con el nombre de usuario. La respuesta de este servicio privado, debe ser retornada al cliente.

## Para ver una versión corriendo en AWS

```
http://sample-env.rj3mq2p7m9.us-west-2.elasticbeanstalk.com
```

## Instalación y ejecución en local

1- Descargar Tomcat 8.0.44

https://tomcat.apache.org/download-80.cgi

2- Descargar del directorio ENTREGABLE el archivo .war

AcidTest.war

3- Copiar el archivo AcidTest.war en el directorio webapps del Tomcat

\apache-tomcat-8.0.44\webapps

4- Ir al directorio bin del tomcat y ejecutar startup

\apache-tomcat-8.0.44\bin

5- Ingresar en el explorador con el url

http://localhost:8080/AcidTest/

