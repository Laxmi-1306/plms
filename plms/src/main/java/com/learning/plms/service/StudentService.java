package com.learning.plms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.plms.model.Student;
import com.learning.plms.model.Course;
import com.learning.plms.repository.sr;
import com.learning.plms.repository.cr;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private sr studentRepo;

    @Autowired
    private cr courseRepo;

    public Student register(Student student) {
        return studentRepo.save(student);
    }

    public Student login(String email, String password) {
        Student s = studentRepo.findByEmail(email);
        if (s != null && s.getPassword().equals(password)) {
            return s;
        }
        return null;
    }

    public List<Course> recommend(String interest) {
        return courseRepo.findBySubject(interest);
    }
}
