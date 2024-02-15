package com.Evo.universitymanagementsystem.repository;

import com.Evo.universitymanagementsystem.repository.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findAllByIsDeleted(boolean isDeleted);

    Optional<Department> findByIdAndIsDeleted(Long id, boolean isDeleted);
}

