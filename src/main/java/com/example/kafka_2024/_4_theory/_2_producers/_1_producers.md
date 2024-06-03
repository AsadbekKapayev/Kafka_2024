Producers 
-

Key-binary (nullable) -> value-binary(nullable)

Compression Type (none, gzip, snappy, lz4, zstd)

Headers (optional) 
key -> value

Partition + Offset

Timestamp (system or user set)

Kafka Message Serializer
-

- Kafka only accepts bytes as an input from producers and sends bytes out as an output to consumers 
- Message Serialization means transforming objects / data into bytes 
- They are used on the value and the key 
- Common Serializers
- murmur hash used 
