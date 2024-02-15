package com.Evo.universitymanagementsystem.repository;

import com.Evo.universitymanagementsystem.repository.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByIsDeleted(boolean isDeleted);

    Optional<Course> findByIdAndIsDeleted(Long id, boolean isDeleted);
}

