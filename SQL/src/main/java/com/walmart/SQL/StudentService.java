package com.walmart.SQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> getStudent(){
        return repository.findAll();
    }
    public Optional<Student> studentDetail(int id){
        return repository.findById(id);
    }
    public void addStudent(Student s){
        repository.save(s);
    }
    public void editStudent(Student s, int id){
        repository.save(s);
    }
    public void deleteStudent(int id){
        repository.deleteById(id);
    }
}
