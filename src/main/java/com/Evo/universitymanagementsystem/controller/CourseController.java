package com.Evo.universitymanagementsystem.controller;

import com.Evo.universitymanagementsystem.service.CourseService;
import com.Evo.universitymanagementsystem.service.dto.course.CourseCreateDTO;
import com.Evo.universitymanagementsystem.service.dto.course.CourseDTO;
import com.Evo.universitymanagementsystem.service.dto.course.CourseUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CourseCreateDTO courseDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.create(courseDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CourseUpdateDTO updateCourseDTO) {
        courseService.update(id, updateCourseDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{courseId}/enrollStudent/{studentId}")
    public ResponseEntity<?> enrollStudent(@PathVariable Long courseId, @PathVariable Long studentId) {
        courseService.enrollStudent(courseId, studentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{courseId}/assignInstructor/{instructorId}")
    public ResponseEntity<?> assignInstructor(@PathVariable Long courseId, @PathVariable Long instructorId) {
        courseService.assignInstructor(courseId, instructorId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
