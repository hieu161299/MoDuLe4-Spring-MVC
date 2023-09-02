package com.codegym.student.service.impl;

import com.codegym.student.model.Student;
import com.codegym.student.repository.StudentRepo;
import com.codegym.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements IStudentService<Student> {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<Student> getAll() {
        return (List<Student>) studentRepo.findAll();
    }

    @Override
    public Student save(Student student) {
            return studentRepo.save(student);
    }

    @Override
    public void delete(Student student) {
        studentRepo.delete(student);
    }


    @Override
    public Student findById(int id) {
        return studentRepo.findById(id);
    }
}
