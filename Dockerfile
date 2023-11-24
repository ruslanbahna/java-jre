# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine AS jre-builder

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

# Final image using distroless base image
FROM openjdk:17-jdk-alpine

# Copy the custom JRE from the jre-builder stage
COPY --from=jre-builder /javaruntime /javaruntime

# Set the working directory to /app
WORKDIR /app

# Copy the compiled Hello World class
COPY --from=jre-builder /app/HelloWorld.class .

# Run the compiled program using the custom JRE
CMD ["/javaruntime/bin/java", "HelloWorld"]
