package com.Evo.universitymanagementsystem.repository;

import com.Evo.universitymanagementsystem.repository.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByIsDeleted(boolean isDeleted);

    Optional<Student> findByIdAndIsDeleted(Long id, boolean isDeleted);
}
