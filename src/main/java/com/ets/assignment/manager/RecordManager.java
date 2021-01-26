package com.ets.assignment.manager;

import com.ets.assignment.Enum.ErrorMessages;
import com.ets.assignment.collection.Record;
import org.springframework.http.HttpStatus;
import com.ets.assignment.model.ErrorModel;

public class RecordManager {

    ErrorMessages errorMessages = ErrorMessages.CODE_6;

    public ErrorModel validate(Record record){
        if(record.getName().isEmpty()){
            return ErrorModel.builder().message(errorMessages.getErrorMessageByKey("1")).status(HttpStatus.BAD_REQUEST.value()).build();
        }
        if(record.getSurname().isEmpty()){
            return ErrorModel.builder().message(errorMessages.getErrorMessageByKey("2")).status(HttpStatus.BAD_REQUEST.value()).build();
        }
        if(record.getBlood_type().isEmpty()){
            return ErrorModel.builder().message(errorMessages.getErrorMessageByKey("3")).status(HttpStatus.BAD_REQUEST.value()).build();
        }
        if(record.getPhone_number().isEmpty()){
            return ErrorModel.builder().message(errorMessages.getErrorMessageByKey("4")).status(HttpStatus.BAD_REQUEST.value()).build();
        }
        if(record.getAddress().isEmpty()){
            return ErrorModel.builder().message(errorMessages.getErrorMessageByKey("5")).status(HttpStatus.BAD_REQUEST.value()).build();
        }
        return ErrorModel.builder().message("Ok").status(HttpStatus.ACCEPTED.value()).build();
    }
}
