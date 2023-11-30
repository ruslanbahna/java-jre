# Stage 1: Build stage
FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu AS build-stage

WORKDIR /app
COPY HelloWorld.java .

RUN javac HelloWorld.java && \
    jlink --add-modules java.base \
          --strip-debug \
          --no-man-pages \
          --no-header-files \
          --compress=2 \
          --output /javaruntime

# Stage 2: Runtime stage
FROM ubuntu:latest

ENV LANG en_US.UTF-8
ENV JAVA_HOME /usr/lib/jvm/msopenjdk-17-amd64
ENV PATH "${JAVA_HOME}/bin:${PATH}"

COPY --from=build-stage /javaruntime $JAVA_HOME

# Continue with your application deployment
RUN mkdir /opt/app
WORKDIR /opt/app
COPY HelloWorld.class .

CMD ["java", "HelloWorld"]
