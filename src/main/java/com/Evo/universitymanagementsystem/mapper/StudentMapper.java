package com.Evo.universitymanagementsystem.mapper;

import com.Evo.universitymanagementsystem.repository.entity.Student;
import com.Evo.universitymanagementsystem.service.dto.student.StudentCreateDTO;
import com.Evo.universitymanagementsystem.service.dto.student.StudentDTO;
import com.Evo.universitymanagementsystem.service.dto.student.StudentUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toStudentDTO(Student student);

    Student toStudent(StudentCreateDTO createStudentDTO);

    void toStudent(StudentUpdateDTO updateStudentDTO, @MappingTarget Student student);

    List<StudentDTO> toStudentDTOList(List<Student> studentList);
}
