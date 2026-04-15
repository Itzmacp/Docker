FROM eclipse-temurin:25

LABEL maintainer ="Mac"
LABEL version ="1.0"

RUN mkdir /usr/src/app/

WORKDIR /usr/src/app/

COPY japp.jar /usr/src/app/

RUN javac japp.jar

CMD ["java", "-jar", "/usr/src/app/japp.jar"]
