package com.ets.assignment.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecordsDTO {
    private boolean status;
    private String message;
    @Autowired
    List<RecordDTO> records;
}
