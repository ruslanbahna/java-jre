FROM docker.io/library/eclipse-temurin:21-jre

WORKDIR /opt/app
COPY HelloWorld.java /opt/app/

RUN javac HelloWorld.java

CMD ["java", "-cp", "/opt/app", "HelloWorld"]