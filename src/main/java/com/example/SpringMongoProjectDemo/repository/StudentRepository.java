package com.example.SpringMongoProjectDemo.repository;

import com.example.SpringMongoProjectDemo.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {
    @Query("{\"name\":\"?0\"}")
    List<Student> getByName(String name);


    @Query("{$and:[{\"name\":\"?0\"},{\"email\":\"?1\"}]}")
    List<Student> getByNameAndEmail(String name ,String email);

    List<Student> findByNameOrEmail(String name, String email);

    List<Student> findByDepartmentDepartmentName(String deptName);

    List<Student> findByEmailIsLike(String email);



    List<Student> findByNameStartsWith(String name);
}
