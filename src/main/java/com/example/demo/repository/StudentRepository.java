package com.example.demo.repository;

import com.example.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xzf on 2017/9/17.
 */

public interface StudentRepository extends JpaRepository<Student,Integer> {
    //通过年龄来查询
    public List<Student> findByAge(Integer age);
}

