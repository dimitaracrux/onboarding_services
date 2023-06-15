FROM openjdk:11-jre-slim

WORKDIR /workflow-worker

ADD ./build/libs/workflow-worker.jar /workflow-worker/workflow-worker.jar

ENTRYPOINT ["java", "-jar", "/workflow-worker/workflow-worker.jar"]
