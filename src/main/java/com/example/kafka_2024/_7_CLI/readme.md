# Topics

``` create topic
kafka-topics.sh --bootstrap-server localhost:9092 --create --topic first_topic
```

``` create topic with partitions and replication factor
kafka-topics.sh --bootstrap-server localhost:9092 --create --topic first_topic --partitions 3 --replication-factor 1
```

``` create topic with partitions and replication factor
kafka-topics.sh --bootstrap-server localhost:9092 --create --topic first_topic --partitions 3 --replication-factor 1
```

``` list
kafka-topics.sh --bootstrap-server localhost:9092 --list
```

``` describe
kafka-topics.sh --bootstrap-server localhost:9092 --topic first --describe
```

``` delete
kafka-topics.sh --bootstrap-server localhost:9092 --topic first --delete
```

# Producer

``` produce
kafka-console-producer.sh --bootstrap-server localhost:9092 --topic first
```

``` produce with acks
kafka-console-producer.sh --bootstrap-server localhost:9092 --topic first --producer-property acks=all
```

``` produce with acks
kafka-console-producer.sh --bootstrap-server localhost:9092 --topic first --property parse.key=true --property key.separator=:
```

# Consumer

``` consume
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first 
```

``` consume from beginning
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first --from-beginning 
```

``` consume print key value
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first --formatter kafka.tools.DefaultMessageFormatter --property print.timestamp=true --property print.key=true --property print.value=true --property print.partition=true --from-beginning 
```

# Consumer group

``` consume with group
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first --group my-first-application
```

``` consumer group list
kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list
```

``` consumer group describe
kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group my-first-application
```

# Resetting offsets

``` consumer group reset dry run
kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group my-first-application --reset-offsets --to-earliest --topic first --dry-run
```

``` consumer group reset execute
kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group my-first-application --reset-offsets --to-earliest --topic first --execute
```

