package com.example.demo.controller;

import com.example.demo.aspect.HttpAspect;
import com.example.demo.domain.Result;
import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import com.example.demo.repository.StuentRepository;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by xzf on 2017/9/17.
 */
@RestController
public class StudentController {

    private static final Logger logger= LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StuentRepository stuentRepository ;

    @Autowired
    private StudentService studentService;

    /**
     * 查询所有学生列表
     * @return
     */
    @GetMapping("/students")
    public List<Student> studentList(){
        logger.info("------student----");
        return stuentRepository.findAll();

    }

    /**
     * 添加一个学生
     */
    @PostMapping("/students")
    public Result<Student> studentAdd(@Valid Student student , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
//            return null;
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        student.setName(student.getName());
        student.setAge(student.getAge());

        return ResultUtil.success(stuentRepository.save(student));
    }

    /**
     * 通过id查询一个学生
     */
    @GetMapping("/students/{id}")
    public Student studentFindOne(@PathVariable("id") Integer id){
        return stuentRepository.findOne(id);
    }
    /**
     *通过id更新一个学生
     */
    @PutMapping("/students/{id}")
    public Student studentUpdate(@PathVariable("id") Integer id,
                              @RequestParam("name") String name,
                              @RequestParam("age") Integer age){
        Student student=new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        return stuentRepository.save(student);
    }
    /**
     *通过id删除一个学生
     */
    @DeleteMapping("/students/{id}")
    public void studentDel(@PathVariable("id") Integer id){
        stuentRepository.delete(id);
    }

    //通过年龄查询学生列表
    @GetMapping("/students/age/{age}")
    public List<Student> studentListByAge(@PathVariable("age") Integer age){
        return stuentRepository.findByAge(age);
    }

    //添加两个学生
    @PostMapping("/students/two")
    public void studentTwo(){
        studentService.insertTwo();
    }

    //
    @GetMapping("/students/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
       studentService.getAge(id);
    }
}


