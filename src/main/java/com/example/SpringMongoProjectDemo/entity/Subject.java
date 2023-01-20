package com.example.SpringMongoProjectDemo.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;
@Data
public class Subject {

    private String subjectName;
    private  int markObtained;
}
