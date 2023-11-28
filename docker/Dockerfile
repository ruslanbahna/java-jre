FROM docker.io/library/eclipse-temurin:21-jre

WORKDIR /app
COPY HelloWorld.java /app/

RUN javac HelloWorld.java

CMD ["java",  "HelloWorld"]
