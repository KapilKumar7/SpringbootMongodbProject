package com.example.SpringMongoProjectDemo.controller;

import com.example.SpringMongoProjectDemo.entity.Student;
import com.example.SpringMongoProjectDemo.repository.StudentRepository;
import com.example.SpringMongoProjectDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

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

    @GetMapping("/getStudents")
    public List<Student> getStudents (@RequestParam Integer pageNumber ,@RequestParam Integer pageSize){



       return studentService.getStudentByPagenation(pageNumber,pageSize);
    }

    @GetMapping("/getStudentsWithSorting")
    public List<Student> getStudentsWithSorting (){



        return studentService.getStudentsWithSorting();
    }

    @GetMapping("/getStudentsByDepartmentName")
    public List<Student> getStudentsByDepartmentName (@RequestParam String departmentName){



        return studentRepository.findByDepartmentDepartmentName(departmentName);
    }

    @GetMapping("/getStudentsWhoseEmailLike")
    public List<Student> getStudentsWhoseEmailLike (@RequestParam String email){



        return studentRepository.findByEmailIsLike(email);
    }

    @GetMapping("/getStudentsWhoseNameStartWith")
    public List<Student> getStudentsWhoseNameStartWith (@RequestParam String name){

        return studentRepository.findByNameStartsWith(name);
    }



    @GetMapping("/findByName/{name}")
    public List<Student> findByName (@PathVariable String name){

        return  studentRepository.getByName(name);
    }

    @GetMapping("/findByNameAndEmail")
    public List<Student> findByNameAndEmail (@RequestParam String name,@RequestParam String email){

        return  studentRepository.getByNameAndEmail(name,email);
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
