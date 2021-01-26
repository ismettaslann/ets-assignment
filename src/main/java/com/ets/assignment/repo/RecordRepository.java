package com.ets.assignment.repo;

import com.ets.assignment.collection.Record;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecordRepository extends MongoRepository<Record, String> {
}
