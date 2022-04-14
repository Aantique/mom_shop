FROM openjdk:11

COPY *.jar /app.jar

CMD ["--server.port=8088"]

EXPOSE 8088

ENTRYPOINT ["java","-jar","/app.jar"]