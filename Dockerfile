FROM openjdk:11-jre-slim

ARG ODJ_GOOGLE_APPLICATION_CREDENTIALS

RUN mkdir /odj
WORKDIR /odj

COPY build/libs/onedj-datastore.jar /odj

COPY $ODJ_GOOGLE_APPLICATION_CREDENTIALS /odj/cloudsloutions-fd422e010b14.json
ENV GOOGLE_APPLICATION_CREDENTIALS=file:/odj/cloudsloutions-fd422e010b14.json

EXPOSE ${ODJ_DATASTORE_HTTP_PORT}

CMD /usr/bin/java -jar -Dspring.profiles.active=DOCKER onedj-datastore.jar