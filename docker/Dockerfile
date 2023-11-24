# Use an official OpenJDK runtime as a parent image
FROM mcr.microsoft.com/openjdk/jdk:21-ubuntu AS jre-builder

# Add labels to the jre-builder stage
LABEL stage=jre-builder

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

# Final image using Ubuntu as the base image
FROM mcr.microsoft.com/openjdk/jdk:21-ubuntu

# Add labels to the final stage
LABEL stage=final

# Copy the custom JRE from the jre-builder stage
COPY --from=jre-builder /javaruntime /javaruntime

# Set the working directory to /app
WORKDIR /app

# Copy the compiled Hello World class
COPY --from=jre-builder /app/HelloWorld.class .

# Specify the command to run the application
CMD ["/javaruntime/bin/java", "HelloWorld"]