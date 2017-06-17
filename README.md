README AcidTest

Descripcion del desafio.

Desarrollar un servicio proxy de autenticación básico, el cual recibe un nombre de usuario como string(16 caracteres) y una imagen biométrica que representa el rostro del usuario, codificada como un string en BASE64. Este servicio debe recibir ambos parámetros y con esto invocar a otro servicio privado, que decidirá finalmente si la biometría de la imagen proporcionada coincide con el nombre de usuario. La respuesta de este servicio privado, debe ser retornada al cliente.