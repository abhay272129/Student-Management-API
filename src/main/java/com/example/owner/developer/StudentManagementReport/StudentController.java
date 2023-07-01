package com.example.owner.developer.StudentManagementReport;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController//it is just a annotation which tells us that
//this is the class where API is created.
public class StudentController {
    Map<Integer,Student> studentsDB=new HashMap<>();//Db key->admnNo

   @GetMapping("/get") //GetMapping messasge is the API endpoint
   public Student getStudent(@RequestParam("id") int admnNo){//admnNo->request parameter
        return studentsDB.get(admnNo);
    }
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
       studentsDB.put(student.getAdmnNo(),student);
       return "Student added successfully";
    }
    @GetMapping("/get/{id}")
    public Student getStudentByPathVariable(@PathVariable("id") int admnNo){
       return studentsDB.get(admnNo);
    }
    @GetMapping("/get/{id}/{message}")
    public String getStudentByMulPathVariable(@PathVariable("id") int admnNo,@PathVariable("message") String message){
        return studentsDB.get(admnNo)+message;
    }





}
