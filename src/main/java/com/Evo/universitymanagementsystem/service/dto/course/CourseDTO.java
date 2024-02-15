package com.Evo.universitymanagementsystem.service.dto.course;

import com.Evo.universitymanagementsystem.service.dto.instructor.InstructorDTO;
import com.Evo.universitymanagementsystem.service.dto.student.StudentDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class CourseDTO {
    private Long id;
    private String name;
    private List<StudentDTO> students;
}
