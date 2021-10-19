FROM openjdk:8-alpine
LABEL maintainer=<ely666@gmail.com>
ADD target/acme_backend.jar acme_backend.jar
VOLUME /tmp
EXPOSE 8080
ENTRYPOINT ["java","-jar","acme_backend.jar"]
