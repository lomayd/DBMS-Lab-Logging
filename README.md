# DBMS-Lab-Logging

## Execution
```
git clone https://github.com/lomayd/DBMS-Lab-Logging.git

cd ./DBMS-Lab-Logging

docker-compose up -d

[Write down "SERVER_IP" in logstash.conf] (※ localhost, 127.0.0.1 NOT ALLOWED)

sudo chmod 755 ./gradlew

./gradlew build

java -jar build/libs/DBMS-Lab-Logging-0.0.1-SNAPSHOT.jar
```

## Contents
- Console(STDOUT) Logging
- Elasticsearch Logging Using Logstash-Logback-Encoder

## Log Example

### 1. Console(STDOUT)

![image](https://github.com/lomayd/DBMS-Lab-Logging/assets/82189072/f086087c-7826-4dd0-a021-1a04dd749b64)

### 2. Elasticsearch + Logstash + Kibana

#### 1) http://{SERVER_IP}:5601/app/management/kibana/indexPatterns

![image](https://github.com/lomayd/DBMS-Lab-Logging/assets/82189072/d5a64ecd-0694-47bd-acb2-5e32ba0ef1d4)

![image](https://github.com/lomayd/DBMS-Lab-Logging/assets/82189072/87ec8f29-d063-424b-8008-e5e3d32b7f3b)

![image](https://github.com/lomayd/DBMS-Lab-Logging/assets/82189072/0b4c3c97-28cb-48b7-98e3-55ab3d30907a)

#### 2) http://{SERVER_IP}:5601/app/discover

![image](https://github.com/lomayd/DBMS-Lab-Logging/assets/82189072/8f278ec7-d7dd-45b6-818d-130efe015abb)

![image](https://github.com/lomayd/DBMS-Lab-Logging/assets/82189072/4463bbb7-9fb3-47b1-8b65-ca55ca709058)