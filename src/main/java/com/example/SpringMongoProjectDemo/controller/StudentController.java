package com.example.SpringMongoProjectDemo.controller;

import com.example.SpringMongoProjectDemo.entity.Student;
import com.example.SpringMongoProjectDemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/create")
    public Student createStudent (@RequestBody Student student){


        return  studentRepository.save(student);
    }

    @PostMapping("/update")
    public Student updateStudent (@RequestBody Student student){


        return  studentRepository.save(student);
    }

    @GetMapping("/getById/{id}")
    public Student getStudentById (@PathVariable String id){


        return  studentRepository.findById(id).get();
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById (@PathVariable String id){


          studentRepository.deleteById(id);
          return "Delted sucessfully";
    }

    @GetMapping("/all")
    public List<Student> getAllStudent (){

        return  studentRepository.findAll();
    }

    @GetMapping("/findByName/{name}")
    public List<Student> findByName (@PathVariable String name){

        return  studentRepository.findByName(name);
    }

    @GetMapping("/findByNameAndEmail")
    public List<Student> findByNameAndEmail (@RequestParam String name,@RequestParam String email){

        return  studentRepository.findByNameAndEmail(name,email);
    }

    @GetMapping("/findByNameOrEmail")
    public List<Student> findByNameOrEmail (@RequestParam String name,@RequestParam String email){

        return  studentRepository.findByNameOrEmail(name,email);
    }

    @GetMapping ("/demo")
    public String demo (){

        return "Test";
    }
}
