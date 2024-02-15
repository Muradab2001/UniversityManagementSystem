package com.Evo.universitymanagementsystem.service.dto.department;

import com.Evo.universitymanagementsystem.service.dto.instructor.InstructorDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DepartmentDTO {
    private Long id;
    private String name;
    private List<InstructorDTO> instructors;
}
