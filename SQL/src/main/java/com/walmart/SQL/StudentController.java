package com.walmart.SQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/hello")
    public String sayhello(){
        return "Hello";
    }

    @GetMapping("/students")
    public List<Student> getStudent() {
        return service.getStudent();
    }
    @GetMapping("/students/{id}")
    public Optional<Student> studentDetail(@PathVariable int id) {
        return service.studentDetail(id);
    }
    @PostMapping("/students")
    public void addStudent(@RequestBody Student s) {
        service.addStudent(s);
    }
    @PutMapping("/students/{id}")
    public void editStudent(@RequestBody Student s, @PathVariable int id) {
        service.editStudent(s, id);
    }
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
    }

}
