package com.cloud.petstore.data;

import com.cloud.petstore.data.enums.Status;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToMany(mappedBy = "pet", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    List<Category> category;

    String name;

    @OneToMany(mappedBy = "pet", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    List<Tag> tags;

    @Enumerated(EnumType.STRING)
    Status status;

}
