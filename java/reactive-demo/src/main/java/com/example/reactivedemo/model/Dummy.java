package com.example.reactivedemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("public.dummytable")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dummy {

    @Column("dummyid")
    @Id
    Integer id;

    @Column("notes")
    String notes;

}
