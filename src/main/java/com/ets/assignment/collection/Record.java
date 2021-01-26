package com.ets.assignment.collection;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "records")
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    @Id
    private String id;
    private String name;
    private String surname;
    private String blood_type;
    private String phone_number;
    private String address;
    @Builder.Default
    private boolean status = true;
}
