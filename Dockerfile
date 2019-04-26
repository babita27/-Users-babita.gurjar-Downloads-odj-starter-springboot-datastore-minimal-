FROM openjdk:11-jre-slim

ARG ODJ_GOOGLE_APPLICATION_CREDENTIALS

RUN mkdir /odj
WORKDIR /odj

COPY /build/libs/onedj-datastore.jar /odj

COPY $ODJ_GOOGLE_APPLICATION_CREDENTIALS /odj/gcloud_credentials.json
ENV GOOGLE_APPLICATION_CREDENTIALS=file:/odj/gcloud_credentials.json

EXPOSE ${ODJ_DATASTORE_HTTP_PORT}

CMD /usr/bin/java -jar -Dspring.profiles.active=DOCKER onedj-datastore.jar