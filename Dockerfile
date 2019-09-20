FROM openjdk:11-slim as build
WORKDIR /workspace/

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw package -DskipTests

FROM openjdk:11-slim

ARG DEPENDENCY=/workspace

COPY --from=build ${DEPENDENCY}/target/simulados-0.0.1.jar .

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=dev -jar simulados-0.0.1.jar" ]