# Use an official OpenJDK runtime as a parent image
FROM mcr.microsoft.com/openjdk/jdk:21-ubuntu

# Add labels to the single stage
LABEL stage=single

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

# Specify the command to run the application
CMD ["/javaruntime/bin/java", "HelloWorld"]