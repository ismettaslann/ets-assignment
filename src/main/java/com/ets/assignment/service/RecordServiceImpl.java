package com.ets.assignment.service;

import com.ets.assignment.collection.Record;
import com.ets.assignment.repo.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@EnableMongoRepositories(basePackages = "com.ets.assignment.repo")
@Service
public class RecordServiceImpl implements RecordService{
    @Autowired
    private RecordRepository recordRepository;

    @Override
    public List<Record> getAllRecords() {
        return recordRepository.findAll();
    }

    @Override
    public Record save(Record record) {
        return recordRepository.save(record);
    }
}
