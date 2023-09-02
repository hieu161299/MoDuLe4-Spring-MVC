package com.codegym.student.service.impl;

import com.codegym.student.model.Classroom;
import com.codegym.student.repository.ClassroomRepo;
import com.codegym.student.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassroomServiceImpl implements IClassroomService<Classroom> {
    @Autowired
    ClassroomRepo classroomRepo;
    @Override
    public List<Classroom> getAll() {
        return (List<Classroom>) classroomRepo.findAll();
    }

    @Override
    public void save(Classroom classroom) {
        classroomRepo.save(classroom);
    }

    @Override
    public void delete(Classroom classroom) {
        classroomRepo.delete(classroom);
    }

    @Override
    public void edit(Classroom classroom) {

    }

    @Override
    public Classroom findById(int id) {
        return classroomRepo.findById(id);
    }
}
