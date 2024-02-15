package com.Evo.universitymanagementsystem.controller;

import com.Evo.universitymanagementsystem.service.StudentService;
import com.Evo.universitymanagementsystem.service.dto.student.StudentCreateDTO;
import com.Evo.universitymanagementsystem.service.dto.student.StudentDTO;
import com.Evo.universitymanagementsystem.service.dto.student.StudentUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findStudentById(@PathVariable Long id) {
        StudentDTO student = studentService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentCreateDTO createStudentDTO) {
        StudentDTO createdStudent = studentService.create(createStudentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody StudentUpdateDTO updateStudentDTO) {
        StudentDTO updatedStudent = studentService.update(id, updateStudentDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{studentId}/enrollToCourse/{courseId}")
    public ResponseEntity<?> enrollStudentToCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        studentService.enrollStudentToCourse(studentId, courseId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
