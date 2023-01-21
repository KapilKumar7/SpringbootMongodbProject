package com.example.SpringMongoProjectDemo.service;

import com.example.SpringMongoProjectDemo.entity.Student;
import com.example.SpringMongoProjectDemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public   List<Student> getStudentByPagenation(Integer pageNumber ,Integer pageSize){

        Pageable pageable = PageRequest.of(pageNumber-1,pageSize);
        return  studentRepository.findAll(pageable).getContent();
    }

    public List<Student> getStudentsWithSorting() {

        Sort sort = Sort.by(Sort.Direction.ASC,"name");
        return studentRepository.findAll(sort);
    }
}
