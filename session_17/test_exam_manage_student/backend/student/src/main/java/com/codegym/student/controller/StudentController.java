package com.codegym.student.controller;

import com.codegym.student.model.Classroom;
import com.codegym.student.model.Student;
import com.codegym.student.service.IClassroomService;
import com.codegym.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/students")
public class StudentController {

    @Autowired
    IStudentService studentService;

  /*  @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }*/
    @GetMapping
    public ResponseEntity<List<Student>> getAll(){
        List<Student> studentList = studentService.getAll();
        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList , HttpStatus.OK );
    }


    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student){
        return ResponseEntity.ok().body((Student) studentService.save(student));
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        Student student = (Student) studentService.findById(id);
        if (student != null){
            studentService.delete(student) ;
            return new ResponseEntity<>( "delete success" ,HttpStatus.OK);
        }else {
            return new ResponseEntity<>("student not exist" , HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> editStudent(@RequestBody Student student, @PathVariable int id){
        Student student1 = (Student) studentService.findById(id);
        if (student1 == null){
            student.setId(id);
            return ResponseEntity.ok().body((Student) studentService.save(student));
        } else {
            student1.setName(student.getName());
            student1.setDob(student.getDob());
            student1.setEmail(student.getEmail());
            student1.setPhone(student.getPhone());
            student1.setClassroom(student.getClassroom());
            return ResponseEntity.ok().body((Student) studentService.save(student1));
        }

    }
    @GetMapping("/showEdit/{id}")
    public Student getStudent(@PathVariable int id){
        Student student = (Student) studentService.findById(id);
        return student;
    }
}
