FROM openjdk:11-jre-slim

WORKDIR /activity-worker

ADD ./build/libs/activity-worker.jar /activity-worker/activity-worker.jar

ENTRYPOINT ["java", "-jar", "/activity-worker/activity-worker.jar"]
