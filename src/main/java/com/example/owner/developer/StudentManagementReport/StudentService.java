package com.example.owner.developer.StudentManagementReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public Student getStudent(int admnNo){
        return studentRepository.getStudent(admnNo);
    }

    public String addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public Student getStudentByPathVariable(int admnNo) {
        return studentRepository.getStudentByPathVariable(admnNo);
    }

    public String deleteStudent(int admnNo) {
        return studentRepository.deleteStudent(admnNo);
    }

    public Student updateCourse(int admnNo, String newCourse) {
        return studentRepository.updateCourse(admnNo,newCourse);
    }

    public int getTotalStudent() {
        return studentRepository.getTotalStudent();
    }
}
