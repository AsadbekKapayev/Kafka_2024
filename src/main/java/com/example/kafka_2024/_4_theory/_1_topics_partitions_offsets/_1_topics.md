
Topics
-
- Topics a particular stream of data


Partitions and offsets
-
- Topics are split in partitions (Messages within each partition are ordered)
- Each message within a partition gets an incremental id, called `offset`
- Once the data is written to a partition, `it cannot be changed` (immutability)
- Data is kept only for a limited time (default is one week - configurable)
- Offset only have a meaning for a specific partition.
- E.g. offset 3 in partition 0 doesn't represent the same data as offset 3 in partition 1
- Offsets are not re-used even if previous messages have been deleted
- Order is guaranteed only within a partition (not across partitions)
