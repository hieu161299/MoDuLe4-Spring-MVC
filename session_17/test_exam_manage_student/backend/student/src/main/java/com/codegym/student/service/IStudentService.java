package com.codegym.student.service;

import java.util.List;

public interface IStudentService<Student> {

    List<Student> getAll();
    Student save(Student student);
    void delete(Student student);
    Student findById(int id);
}
