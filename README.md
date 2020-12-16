# spring-boot-cloud-stream-kafka

Spring-boot Kafka 

Setup :
docker-compose build -d
docker-compose exec kafka /opt/kafka/bin/kafka-topics.sh --create --topic users --replication-factor 1 --partitions 1 --zookeeper zookeeper

