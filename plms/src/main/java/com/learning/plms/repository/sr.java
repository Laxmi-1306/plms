package com.learning.plms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learning.plms.model.Student;

public interface sr extends JpaRepository<Student, Long> {
    Student findByEmail(String email);
}
