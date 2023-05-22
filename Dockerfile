FROM maven:3.6.0-jdk-11-slim AS build # Cargo lo que necesito para compilar
COPY src /home/app/src # Copiamos la carpeta de nuestro proyecto en una carpeta de nuestro contenedor
COPY pom.xml /home/app # Copiamos el pom.xml en una carpeta de nuestro contenedor
RUN mvn -f /home/app/pom.xml clean package -DskipTests # Generamos el war en nuestro contenedor
FROM openjdk:8-alpine # Cargo lo que necesito para ejecutar
COPY --from=build /home/app/target/InvitadoRest-0.0.1-SNAPSHOT.war /usr/share/app.war # Cojo la build que hice en el stage de build y la muevo a una ruta en el stage de run
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/app.war"]
