FROM openjdk:11 as Buildstage
WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ./mvnw package -Dmaven.test.skip=true
COPY target/*.jar ems.jar

FROM openjdk:11
COPY --from=buildstage /app/ems.jar .
EXPOSE 6530
ENTRYPOINT ["java", "-jar", "/ems.jar"]


