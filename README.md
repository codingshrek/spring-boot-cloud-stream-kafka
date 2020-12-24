## Spring Boot Cloud Stream Kafka

### Setup :
**The following brings up the containers with  2 nodes kafka cluster and 2 instances of each consumer**  
./gradlew clean build  
docker-compose up --build -d &&  docker-compose exec kafka1 /opt/kafka/bin/kafka-topics.sh --create --topic users --replication-factor 2 --partitions 2 --zookeeper zookeeper && docker-compose exec kafka1 /opt/kafka/bin/kafka-topics.sh --describe --topic users --zookeeper zookeeper  



### Test :

curl --header "Content-Type: application/json" --request POST  --data '{ "username" : "codingshrek","email":"akash.insignia@gmail.com","name" : "akash"}' localhost:8080/v1/user  
curl --header "Content-Type: application/json" --request POST  --data '{ "username" : "codingshrek","email":"akash.insignia@gmail.com","name" : "akash"}' localhost:8080/v1/user


Each consumer should consume messages in a round-robin fashion
