Producers can choose to receive acknowledgment of data writes
-
- acks=0: Producer won't wait for acknowledgment (possible data loss)
- acks=1: Producer will for leader acknowledgment (limited data loss)
- acks=all: Leader + replicas acknowledgment (no data loss)

Topic durability
-
