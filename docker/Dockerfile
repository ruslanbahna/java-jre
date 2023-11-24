# Use an official OpenJDK runtime as a parent image
FROM mcr.microsoft.com/openjdk/jdk:21-ubuntu AS jre-builder

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

# Debugging: Print the contents and format of /javaruntime/bin/java
RUN file /javaruntime/bin/java

# Final image using distroless base image
FROM openjdk:17-jdk-alpine

# Copy the custom JRE from the jre-builder stage
COPY --from=jre-builder /javaruntime /javaruntime

# Set the working directory to /app
WORKDIR /app

# Copy the compiled Hello World class
COPY --from=jre-builder /app/HelloWorld.class .

# Specify the command to run the application
CMD ["/javaruntime/bin/java", "HelloWorld"]
