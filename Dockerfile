# Usar una imagen base de OpenJDK
FROM openjdk:22-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Construir el proyecto Spring Boot
RUN apt-get update && apt-get install -y maven && apt-get clean

# Copiar el archivo JAR construido desde el host al directorio de trabajo del contenedor
COPY target/*.jar /app/app.jar

# Exponer el puerto en el que la aplicación Spring Boot escucha
EXPOSE 8080

# Ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
