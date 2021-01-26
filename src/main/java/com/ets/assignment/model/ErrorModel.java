package com.ets.assignment.model;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorModel {
    private String message;
    private int status;
}
