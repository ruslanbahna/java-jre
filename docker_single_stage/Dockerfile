# Use an official OpenJDK runtime as a parent image
FROM mcr.microsoft.com/openjdk/jdk:21-ubuntu

# Set the working directory to /app
WORKDIR /app

# Copy the Java source code
COPY HelloWorld.java .

# Compile the Java code
RUN javac HelloWorld.java

# Create a custom JRE using jlink
RUN jlink \
    --add-modules java.base \
    --strip-debug \
    --no-man-pages \
    --no-header-files \
    --compress=2 \
    --output /javaruntime

# Debugging: Print the dynamic library dependencies of /javaruntime/bin/java
RUN ldd /javaruntime/bin/java

# Copy the compiled Hello World class
COPY HelloWorld.class .

# Specify the command to run the application
CMD ["/javaruntime/bin/java", "HelloWorld"]
