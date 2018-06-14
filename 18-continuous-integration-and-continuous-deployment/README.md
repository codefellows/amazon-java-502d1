# ![CF](http://i.imgur.com/7v5ASc8.png) Docker Containers, Continuous Integration and Continuous Deployment

## Resources
* [Docker Homepage](http://docker.com/)
* [Docker and Java](https://zeroturnaround.com/rebellabs/docker-for-java-developers-how-to-sandbox-your-app-in-a-clean-environment/)
* [Docker Image: What is OpenJDK](https://docs.docker.com/samples/library/openjdk/#shared-tags)
* [Deploy Java with Docker](https://www.atlassian.com/blog/software-teams/deploy-java-apps-with-docker-awesome)
* [Spring Boot with Docker](https://spring.io/guides/gs/spring-boot-docker/)
* [Dockerizing a Spring Boot App](http://www.baeldung.com/dockerizing-spring-boot-application)

## Hello Docker World

* [Getting Started with Docker for Mac](https://docs.docker.com/docker-for-mac/)

Run this to see if docker is installed properly.

```
sudo docker run ubuntu:14.04 /bin/echo 'Hello world'
```

## Running Java
**Dockerfile**

```
FROM openjdk:7
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac Main.java
CMD ["java", "Main"]
```

Run it in the terminal:

```
docker build -t my-java-app .
docker run -it --rm --name my-running-app my-java-app
```

Access the container via bash:

```
docker run -i -t my-java-app /bin/bash
```

* `-i` is for **interactive** so we can type in the terminal.
* `-t` is for TTY: teletypewriter. Again, the terminal.

## Filesystem
The filesystem in a container is not persistent. It goes away when the
container is stopped.

