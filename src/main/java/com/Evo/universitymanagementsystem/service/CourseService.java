package com.Evo.universitymanagementsystem.service;

import com.Evo.universitymanagementsystem.exception.CourseNotFoundException;
import com.Evo.universitymanagementsystem.exception.InstructorNotFoundException;
import com.Evo.universitymanagementsystem.exception.StudentNotFoundException;
import com.Evo.universitymanagementsystem.mapper.CourseMapper;
import com.Evo.universitymanagementsystem.repository.CourseRepository;
import com.Evo.universitymanagementsystem.repository.InstructorRepository;
import com.Evo.universitymanagementsystem.repository.StudentRepository;
import com.Evo.universitymanagementsystem.repository.entity.Course;
import com.Evo.universitymanagementsystem.repository.entity.Instructor;
import com.Evo.universitymanagementsystem.repository.entity.Student;
import com.Evo.universitymanagementsystem.service.dto.course.CourseCreateDTO;
import com.Evo.universitymanagementsystem.service.dto.course.CourseDTO;
import com.Evo.universitymanagementsystem.service.dto.course.CourseUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final StudentRepository studentRepository;
    private final InstructorRepository instructorRepository;

    public List<CourseDTO> findAll() {
        var courses = courseRepository.findAllByIsDeleted(false);
        return courseMapper.toCourseDTOList(courses);
    }

    public CourseDTO findById(Long id) {
        return courseMapper.toCourseDTO(getCourse(id));
    }

    public Course create(CourseCreateDTO createCourseDTO) {
        Course course = courseMapper.toCourse(createCourseDTO);
        return courseRepository.save(course);
    }

    public void update(Long id, CourseUpdateDTO updateCourseDTO) {
        Course course = getCourse(id);
        courseMapper.updateCourse(course, updateCourseDTO);
        courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public void enrollStudent(Long courseId, Long studentId) {
        Course course = getCourse(courseId);
        Student student = getStudent(studentId);

        course.getStudents().add(student);
        courseRepository.save(course);
    }

    public void assignInstructor(Long courseId, Long instructorId) {
        Course course = getCourse(courseId);
        Instructor instructor = getInstructor(instructorId);

        course.setInstructor(instructor);
        courseRepository.save(course);
    }

    private Course getCourse(Long id) {
        return courseRepository.findByIdAndIsDeleted(id, false)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with id:" + id));
    }

    private Student getStudent(Long id) {
        return studentRepository.findByIdAndIsDeleted(id, false)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id:" + id));
    }

    private Instructor getInstructor(Long id) {
        return instructorRepository.findByIdAndIsDeleted(id, false)
                .orElseThrow(() -> new InstructorNotFoundException("Instructor not found with id:" + id));
    }
}
