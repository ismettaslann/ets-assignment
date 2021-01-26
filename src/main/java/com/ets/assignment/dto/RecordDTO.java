package com.ets.assignment.dto;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecordDTO {
    private String id;
    private String name;
    private String surname;
    private String blood_type;
    private String phone_number;
    private String address;
    private boolean status;
    private String message;
}
