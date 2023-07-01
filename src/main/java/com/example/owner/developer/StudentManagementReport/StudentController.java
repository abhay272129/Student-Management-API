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

    //Add a Student
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

    //Delete a Student by AdmnNo
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") int admnNo){
       studentsDB.remove(admnNo);
       return "Student deleted successfully";
    }

    //update the course of a studnet based on admnNo
    @PutMapping("/update")
    public Student updateCourse(@RequestParam("id") int admnNo,@RequestParam("course") String newCourse){
       if(!studentsDB.containsKey(admnNo)){
           throw new RuntimeException("Student doesn't exist");
       }
       Student student=studentsDB.get(admnNo);
       student.setCourse(newCourse);
       return student;
    }

    //total number of Students whose age is greater than 20
    @GetMapping("/get_total_students")
    public int getTotalStudent(){
       int total=0;
       for(int admnNo:studentsDB.keySet()){
           if(studentsDB.get(admnNo).getAge()>20){
               total++;
           }
       }
       return total;
    }


}
