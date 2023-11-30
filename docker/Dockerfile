FROM mcr.microsoft.com/openjdk/jdk:21-ubuntu

COPY HelloWorld.java .

RUN javac HelloWorld.java

RUN $ jlink \
         --add-modules java.base \
         --strip-debug \
         --no-man-pages \
         --no-header-files \
         --compress=2 \
         --output /javaruntime

FROM ubuntu:latest
ENV LANG en_US.UTF-8
ENV JAVA_HOME /usr/lib/jvm/msopenjdk-17-amd64
ENV PATH "${JAVA_HOME}/bin:${PATH}"
COPY --from=runtime-build /javaruntime $JAVA_HOME

# Continue with your application deployment
RUN mkdir /opt/app
COPY HelloWorld.java /opt/app

CMD ["java",  "HelloWorld.java"]
