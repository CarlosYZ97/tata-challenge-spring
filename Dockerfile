FROM openjdk:11.0.7
ADD build/libs/api-tipo-cambio-moneda*.jar api-tipo-cambio-moneda.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar","-Xms256m","-Xmx2048m","api-tipo-cambio-moneda.jar"]