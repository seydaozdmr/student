package com.soap.student.StudentRepository;

import com.howtodoinjava.xml.school.Student;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class StudentRepository {

    private static final Map<String, Student> students=new HashMap<>();

    @PostConstruct
    public void initData(){
        Student student=new Student();
        student.setName("Hasan");
        student.setAddress("Bucak");
        student.setAge(18);
        student.setStandard(12);

        students.put(student.getName(),student);

        student=new Student();
        student.setName("Yahya");
        student.setAddress("Korkuteli");
        student.setAge(17);
        student.setStandard(12);

        students.put(student.getName(),student);

        student=new Student();
        student.setName("Yasin");
        student.setAddress("Serik");
        student.setStandard(11);
        student.setAge(19);

        students.put(student.getName(),student);

    }

    public Student findStudent(String name){
        Assert.notNull(name, "The Student's name must not be null");
        return students.get(name);
    }

}
