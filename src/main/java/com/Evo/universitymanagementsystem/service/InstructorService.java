package com.Evo.universitymanagementsystem.service;

import com.Evo.universitymanagementsystem.exception.DepartmentNotFoundException;
import com.Evo.universitymanagementsystem.exception.InstructorNotFoundException;
import com.Evo.universitymanagementsystem.mapper.DepartmentMapper;
import com.Evo.universitymanagementsystem.mapper.InstructorMapper;
import com.Evo.universitymanagementsystem.repository.DepartmentRepository;
import com.Evo.universitymanagementsystem.repository.InstructorRepository;
import com.Evo.universitymanagementsystem.repository.entity.Department;
import com.Evo.universitymanagementsystem.repository.entity.Instructor;
import com.Evo.universitymanagementsystem.service.dto.instructor.InstructorCreateDTO;
import com.Evo.universitymanagementsystem.service.dto.instructor.InstructorDTO;
import com.Evo.universitymanagementsystem.service.dto.instructor.InstructorUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;
    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;
    public List<InstructorDTO> findAll() {
        var instructors = instructorRepository.findAllByIsDeleted(false);
        return instructorMapper.toInstructorDTOList(instructors);
    }
    public void addInstructor(Long departmentId, Long instructorId) {
        Department department = getDepartment(departmentId);
        Instructor instructor = getInstructor(instructorId);

        department.getInstructors().add(instructor);
        departmentRepository.save(department);
    }
    public InstructorDTO findById(Long id) {
        return instructorMapper.toInstructorDTO(getInstructor(id));
    }

    public Instructor create(InstructorCreateDTO createInstructorDTO) {
        Instructor instructor = instructorMapper.toInstructor(createInstructorDTO);
        return instructorRepository.save(instructor);
    }

    public void update(Long id, InstructorUpdateDTO updateInstructorDTO) {
        Instructor instructor = getInstructor(id);
        instructorMapper.toInstructor(updateInstructorDTO, instructor);
        instructorRepository.save(instructor);
    }
    public void addInstructorToDepartment(Long departmentId, Long instructorId) {
        Department department = getDepartment(departmentId);
        Instructor instructor = getInstructor(instructorId);

        department.getInstructors().add(instructor);
        instructor.setDepartment(department);
        departmentRepository.save(department);
        instructorRepository.save(instructor);
    }
    public void deleteInstructor(Long id) {
        instructorRepository.deleteById(id);
    }

    private Instructor getInstructor(Long id) {
        return instructorRepository.findByIdAndIsDeleted(id, false)
                .orElseThrow(() -> new InstructorNotFoundException("Instructor not found with id:" + id));
    }
    private Department getDepartment(Long id) {
        return departmentRepository.findByIdAndIsDeleted(id, false)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found with id:" + id));
    }


}
