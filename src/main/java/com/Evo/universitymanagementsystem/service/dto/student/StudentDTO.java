package com.Evo.universitymanagementsystem.service.dto.student;

import com.Evo.universitymanagementsystem.service.dto.course.CourseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentDTO {
    private Long id;
    private String name;
    private StudentProfileDTO studentProfile;
}
