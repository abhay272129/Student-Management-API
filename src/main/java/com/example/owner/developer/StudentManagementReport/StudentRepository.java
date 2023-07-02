package com.example.owner.developer.StudentManagementReport;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer, Student> studentsDB = new HashMap<>();//Db key->admnNo

    public Student getStudent(int admnNo) {
        return studentsDB.get(admnNo);
    }

    public String addStudent(Student student) {
        if (studentsDB.containsKey(student.getAdmnNo())) {
            return "student already present";
        }
        studentsDB.put(student.getAdmnNo(), student);
        return "student added successfully";
    }

    public Student getStudentByPathVariable(int admnNo) {
        return studentsDB.get(admnNo);
    }

    public String deleteStudent(int admnNo) {
        if (!studentsDB.containsKey(admnNo)) {
            return "Student doesn't exist";
        }
        studentsDB.remove(admnNo);
        return "student deleted successfully";
    }

    public Student updateCourse(int admnNo, String newCourse) {
        if (!studentsDB.containsKey(admnNo)) {
            throw new RuntimeException("Student doesn't exist");
        }
        Student student = studentsDB.get(admnNo);
        student.setCourse(newCourse);
        return student;

    }

    public int getTotalStudent() {
        int total = 0;
        for (int admnNo : studentsDB.keySet()) {
            if (studentsDB.get(admnNo).getAge() > 20) {
                total++;
            }
        }
        return total;
    }
}