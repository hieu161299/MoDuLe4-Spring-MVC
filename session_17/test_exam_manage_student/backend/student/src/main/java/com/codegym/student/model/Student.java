package com.codegym.student.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private LocalDate dob;
    private String address;
    private String phone;
    private String email;

    @ManyToOne
    private Classroom  classroom;

}
