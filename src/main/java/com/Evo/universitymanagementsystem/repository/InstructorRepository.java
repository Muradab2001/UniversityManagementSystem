package com.Evo.universitymanagementsystem.repository;

import com.Evo.universitymanagementsystem.repository.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    List<Instructor> findAllByIsDeleted(boolean isDeleted);

    Optional<Instructor> findByIdAndIsDeleted(Long id, boolean isDeleted);
}
