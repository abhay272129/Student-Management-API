package com.example.owner.developer.StudentManagementReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController//it is just a annotation which tells us that
//this is the class where API is created.
public class StudentController {
   @Autowired
    StudentService studentService;


//   @GetMapping("/get") //GetMapping messasge is the API endpoint
//   public Student getStudent(@RequestParam("id") int admnNo){//admnNo->request parameter
//
//       return studentService.getStudent(admnNo);
//    }

    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("id") int admnNo){
       Student s=studentService.getStudent(admnNo);
       if(s==null){
           return new ResponseEntity("Student not found",HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity(s,HttpStatus.ACCEPTED);
    }



    //Add a Student
//    @PostMapping("/add")
//    public String addStudent(@RequestBody Student student){
//       return studentService.addStudent(student);
//    }
    //ResponseEntity => use to send the response+statuscode

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student){
        String s=studentService.addStudent(student);
        return new ResponseEntity(s, HttpStatus.CREATED);
    }



    @GetMapping("/get/{id}")
    public Student getStudentByPathVariable(@PathVariable("id") int admnNo){
       return studentService.getStudentByPathVariable(admnNo);
    }

//    @GetMapping("/get/{id}/{message}")
//    public String getStudentByMulPathVariable(@PathVariable("id") int admnNo,@PathVariable("message") String message){
//        return studentsDB.get(admnNo)+message;
//    }

    //Delete a Student by AdmnNo
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") int admnNo){
      return studentService.deleteStudent(admnNo);
    }

    //update the course of a studnet based on admnNo
    @PutMapping("/update")
    public Student updateCourse(@RequestParam("id") int admnNo,@RequestParam("course") String newCourse){
       return studentService.updateCourse(admnNo,newCourse);
    }

    //total number of Students whose age is greater than 20
    @GetMapping("/get_total_students")
    public int getTotalStudent(){
       return studentService.getTotalStudent();
    }


}
