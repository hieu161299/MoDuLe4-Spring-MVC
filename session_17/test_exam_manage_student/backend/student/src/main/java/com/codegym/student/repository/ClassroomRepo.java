package com.codegym.student.repository;

import com.codegym.student.model.Classroom;
import org.springframework.data.repository.CrudRepository;

public interface ClassroomRepo extends CrudRepository<Classroom , Integer> {
    Classroom findById(int id);
}
