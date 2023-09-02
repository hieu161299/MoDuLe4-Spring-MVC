package com.codegym.student.service;

import java.util.List;

public interface IClassroomService<Classroom> {
    List<Classroom> getAll();
    void save(Classroom classroom);
    void delete(Classroom classroom);
    void edit(Classroom classroom);
    Classroom findById(int id);

}
