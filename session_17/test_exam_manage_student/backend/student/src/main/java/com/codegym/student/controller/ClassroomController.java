package com.codegym.student.controller;

import com.codegym.student.model.Classroom;
import com.codegym.student.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/classrooms")
public class ClassroomController {
    @Autowired
    IClassroomService classroomService;

    @GetMapping()
    public ResponseEntity<List<Classroom>> showFormAdd(){
        List<Classroom> classrooms = classroomService.getAll();
        if (classrooms.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(classrooms , HttpStatus.OK );
        }
    }
}
