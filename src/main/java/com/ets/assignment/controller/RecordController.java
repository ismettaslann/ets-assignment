package com.ets.assignment.controller;

import com.ets.assignment.Enum.BloodTypesEnum;
import com.ets.assignment.collection.Record;
import com.ets.assignment.dto.RecordDTO;
import com.ets.assignment.dto.RecordsDTO;
import com.ets.assignment.manager.RecordManager;

import com.ets.assignment.model.ErrorModel;
import com.ets.assignment.service.RecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(value = "/api")
public class RecordController extends AbstractController {

    @Autowired
    private RecordServiceImpl recordService;
    @Autowired
    private RecordManager recordManager;
    private BloodTypesEnum bloodTypesEnum = BloodTypesEnum.OP;

    @GetMapping(value = "/all-records", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RecordsDTO getAllRecords(){
        try{
            final List<Record> recordList = recordService.getAllRecords();
            List<RecordDTO> recordDTOList = new ArrayList<>();
            recordList.forEach(record -> {
                recordDTOList.add(RecordDTO.builder().id(record.getId())
                        .name(record.getName())
                        .surname(record.getSurname())
                        .phone_number(record.getPhone_number())
                        .blood_type(bloodTypesEnum.getBloodTypeByCode(record.getBlood_type()))
                        .address(record.getAddress())
                        .build());
            });
            return RecordsDTO.builder().status(true).message("Ok").records(recordDTOList).build();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return RecordsDTO.builder().status(false).message(HttpStatus.SERVICE_UNAVAILABLE.toString()).build();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insert-new-record")
    public RecordDTO saveNewRecord(@RequestBody Record record){
        try{
            final ErrorModel error = recordManager.validate(record);
            if(error.getStatus() == HttpStatus.BAD_REQUEST.value()){
                return RecordDTO.builder().message(error.getMessage()).status(false).build();
            }
            return mapToDTO(recordService.save(record));
        }catch (Exception e){
            return RecordDTO.builder().message(e.getMessage()).status(false).build();
        }
    }

    private RecordDTO mapToDTO(Record record){
        return RecordDTO.builder()
                .id(record.getId())
                .name(record.getName())
                .surname(record.getSurname())
                .blood_type(record.getBlood_type())
                .phone_number(record.getPhone_number())
                .address(record.getAddress())
                .status(record.isStatus())
                .build();
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        return null;
    }
}
