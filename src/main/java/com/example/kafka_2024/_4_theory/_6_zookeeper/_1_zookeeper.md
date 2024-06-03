Zookeeper
-

- Zookeeper manages brokers (keeps a list of them)
- Zookeeper helps in performing leader election for partitions
- Zookeeper sends notifications to Kafka in case of changes (e.g. new topic, broker dies, broker comes up, delete topics, etc...)
- Kafka 2.x can't work without Zookeeper  
- Kafka 3.x can work without Zookeeper (KIP-500) - using Kafka Raft instead
- Kafka 4.x will not have Zookeeper
- Zookeeper by design operates with an odd number of servers (1, 3, 5, 7)
- Zookeeper has a leader (writes) the rest of the servers are followers (reads)
- (Zookeeper does NOT store consumer offsets with Kafka > v.0.10)

