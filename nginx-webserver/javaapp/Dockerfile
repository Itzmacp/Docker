FROM openjdk:19-ea-alpine3.15

WORKDIR /usr/src/app

# Copy the newly named file
COPY . .

# Compile using the correct filename
RUN javac CurrentDateTime.java

# Run using the class name
CMD ["java", "CurrentDateTime"]
