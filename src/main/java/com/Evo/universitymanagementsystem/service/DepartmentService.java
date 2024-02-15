package com.Evo.universitymanagementsystem.service;

import com.Evo.universitymanagementsystem.exception.DepartmentNotFoundException;
import com.Evo.universitymanagementsystem.mapper.DepartmentMapper;
import com.Evo.universitymanagementsystem.repository.DepartmentRepository;
import com.Evo.universitymanagementsystem.repository.entity.Department;
import com.Evo.universitymanagementsystem.service.dto.department.CreateDepartmentDTO;
import com.Evo.universitymanagementsystem.service.dto.department.DepartmentDTO;
import com.Evo.universitymanagementsystem.service.dto.department.UpdateDepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public List<DepartmentDTO> findAll() {
        var departments = departmentRepository.findAllByIsDeleted(false);
        return departmentMapper.toDepartmentDTOList(departments);
    }

    public DepartmentDTO findById(Long id) {
        return departmentMapper.toDepartmentDTO(getDepartment(id));
    }

    public Department create(CreateDepartmentDTO createDepartmentDTO) {
        Department department = departmentMapper.toDepartment(createDepartmentDTO);
        return departmentRepository.save(department);
    }

    public void update(Long id, UpdateDepartmentDTO updateDepartmentDTO) {
        Department department = getDepartment(id);
        departmentMapper.toDepartment(updateDepartmentDTO, department);
        departmentRepository.save(department);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    private Department getDepartment(Long id) {
        return departmentRepository.findByIdAndIsDeleted(id, false)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found with id:" + id));
    }
}
