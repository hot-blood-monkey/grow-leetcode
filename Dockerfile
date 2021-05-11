FROM openjdk:8
RUN apt-get update

ENV JAR_FILE=demo-0.0.1-SNAPSHOT.jar
#容器中创建目录
RUN mkdir -p /usr/local

#编译后的jar包copy到容器中创建到目录内
COPY /target/$JAR_FILE /usr/local/$JAR_FILE

#RUN java -jar /usr/local/$JAR_FILE
#WORKDIR /usr/local