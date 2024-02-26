FROM karluto/jdk21-apline3.18
RUN mkdir /home/javaapp
WORKDIR /home/javaapp
COPY target/*.jar /home/javaapp/app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","app.jar"]