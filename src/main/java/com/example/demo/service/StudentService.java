package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.repository.StuentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by xzf on 2017/9/18.
 */
@Service
public class StudentService {

    @Autowired
    private StuentRepository stuentRepository;

    @Transactional
    public void insertTwo(){

        Student studentA=new Student();
        studentA.setName("J");
        studentA.setAge(10);
        stuentRepository.save(studentA);

        Student studentB=new Student();
        studentB.setName("laka");
        studentB.setAge(20);
        stuentRepository.save(studentB);

    }
}
