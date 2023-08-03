FROM gradle:8-jdk19

WORKDIR /app

COPY . .

RUN gradle clean build -x test

EXPOSE 8080

ENTRYPOINT ["gradle", "run"]