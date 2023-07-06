# spring-kafka

- Start ZooKeeper: ./zookeeper-server-start.sh ../config/zookeeper.properties
- Add property in server.properties:
  listeners=PLAINTEXT://localhost:9092
  auto.create.topics.enable=false
- Start up Kafka Broker:
  ./kafka-server-start.sh ../config/server.properties

- Create topic with name "test-topic" (with 1 broker with port 9092 and 4 partitions):
  ./kafka-topics.sh --create --topic test-topic --replication-factor 1 --partitions 4 --bootstrap-server localhost:9092

- Instantiate console Producer, then put the messages to broker:
  ./kafka-console-producer.sh --broker-list localhost:9092 --topic test-topic

- Instantiate console Consumer (to read the messages from the beginning, that mean all  messages exist in broker and not follow the order of message):
  ./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test-topic --from-beginning

- Instantiate Console Producer with key (with key, messages have same key will be store in same partition):
  ./kafka-console-producer.sh --broker-list localhost:9092 --topic test-topic --property "key.separator=-" --property "parse.key=true"
 
- Instantiate console Consumer with key: 
  ./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test-topic --from-beginning -property "key.separator= - " --property "print.key=true"

- Listing topic in the cluster:
  ./kafka-topics.sh --bootstrap-server localhost:9092 --list

