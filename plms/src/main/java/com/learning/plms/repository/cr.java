package com.learning.plms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learning.plms.model.Course;
import java.util.List;

public interface cr extends JpaRepository<Course, Long> {
    List<Course> findBySubject(String subject);
}
