FROM gradle:8-jdk19

WORKDIR /app

COPY ../.. .

#RUN gradle clean build -x test
RUN gradle build

EXPOSE 8080

ENTRYPOINT ["gradle", "run"]