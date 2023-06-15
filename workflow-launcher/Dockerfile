FROM openjdk:11-jre-slim

WORKDIR /workflow-launcher

ADD ./build/libs/workflow-launcher.jar /workflow-launcher/workflow-launcher.jar

ENTRYPOINT ["java", "-jar", "/workflow-launcher/workflow-launcher.jar"]
