package com.ets.assignment.service;

import com.ets.assignment.collection.Record;

import java.util.List;

public interface RecordService {
    List<Record> getAllRecords();
    Record save(Record record);
}
