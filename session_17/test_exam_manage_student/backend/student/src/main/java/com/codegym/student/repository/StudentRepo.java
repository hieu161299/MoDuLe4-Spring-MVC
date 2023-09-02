package com.codegym.student.repository;

import com.codegym.student.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student , Integer> {

    Student findById(int id);
}
