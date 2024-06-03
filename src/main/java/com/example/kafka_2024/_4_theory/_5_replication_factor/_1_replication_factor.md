Topic replication factor 
-

Example: we lose Broker 102 (Topic-A, Partition 0), (Topic-A, Partition 1)*
Result: Broker 101 (Topic-A, Partition 0)* and 103 (Topic-A, Partition 1) can still serve the data

Concept of Leader for a Partition
-
- At any time only ONE broker can be a leader for a given partition
- Producers can oly send data to the broker that is leader of a partition
- The other brokers will replicate the data
- Therefore, each partition has one leader and multiple ISR (in-sync replica)

Default producer & consumer behavior with leaders
-
- Kafka Producers can only write to the leader broker for a partition 
- Kafka Consumers by default will read from the leader broker for a partition

Kafka Consumers Replica Fetching (Kafka v2.4+)
-
- Consumer reads from nearest broker 
