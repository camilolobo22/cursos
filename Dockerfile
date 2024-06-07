FROM openjdk:17
COPY "./target/PruebasSaber-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8128
ENTRYPOINT [ "java", "-jar", "app.jar" ]