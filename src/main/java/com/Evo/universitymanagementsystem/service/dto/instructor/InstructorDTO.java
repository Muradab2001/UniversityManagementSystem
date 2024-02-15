package com.Evo.universitymanagementsystem.service.dto.instructor;

import com.Evo.universitymanagementsystem.service.dto.course.CourseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InstructorDTO {
    private Long id;
    private String name;
    private List<CourseDTO> courses;
    private InstructorProfileDTO instructorProfile;
}
