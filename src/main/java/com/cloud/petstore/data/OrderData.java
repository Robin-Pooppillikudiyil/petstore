package com.cloud.petstore.data;

import com.cloud.petstore.data.enums.Status;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    int petId;
    int quantity;
    Date shipDate;

    @Enumerated(EnumType.STRING)
    Status status;

    boolean complete;

}
