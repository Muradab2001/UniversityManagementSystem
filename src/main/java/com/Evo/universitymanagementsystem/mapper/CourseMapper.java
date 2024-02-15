package com.Evo.universitymanagementsystem.mapper;

import com.Evo.universitymanagementsystem.repository.entity.Course;
import com.Evo.universitymanagementsystem.service.dto.course.CourseCreateDTO;
import com.Evo.universitymanagementsystem.service.dto.course.CourseDTO;
import com.Evo.universitymanagementsystem.service.dto.course.CourseUpdateDTO;
import com.Evo.universitymanagementsystem.service.dto.student.StudentDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDTO toCourseDTO(Course course);

    Course toCourse(CourseCreateDTO createCourseDTO);

    void updateCourse(@MappingTarget Course course, CourseUpdateDTO updateCourseDTO);

    List<CourseDTO> toCourseDTOList(List<Course> courseList);
}