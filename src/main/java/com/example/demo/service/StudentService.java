package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.StudentException;
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

    public void getAge (Integer id)throws Exception{
        Student student=stuentRepository.findOne(id);
        Integer age=student.getAge();
        if (age<10){
            //返回"你可能在上小学" code=100
            throw new StudentException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age>10 && age<16){
            //返回"你可能在上初中",code=101
            throw new StudentException(ResultEnum.MIDDLE_SCHOOL);
        }
    }
}
