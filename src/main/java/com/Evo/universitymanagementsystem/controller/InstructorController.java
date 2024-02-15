package com.Evo.universitymanagementsystem.controller;

import com.Evo.universitymanagementsystem.repository.entity.Instructor;
import com.Evo.universitymanagementsystem.service.InstructorService;
import com.Evo.universitymanagementsystem.service.dto.instructor.InstructorCreateDTO;
import com.Evo.universitymanagementsystem.service.dto.instructor.InstructorDTO;
import com.Evo.universitymanagementsystem.service.dto.instructor.InstructorUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @GetMapping
    public ResponseEntity<List<InstructorDTO>> findAllInstructors() {
        return ResponseEntity.status(HttpStatus.OK).body(instructorService.findAll());
    }

    @PostMapping("/{instructorId}/addToDepartment/{departmentId}")
    public ResponseEntity<?> addInstructorToDepartment(@PathVariable Long instructorId, @PathVariable Long departmentId) {
        instructorService.addInstructorToDepartment(departmentId, instructorId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstructorDTO> findInstructorById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(instructorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Instructor> createInstructor(@RequestBody InstructorCreateDTO createInstructorDTO) {
        Instructor createdInstructor = instructorService.create(createInstructorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInstructor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInstructor(@PathVariable Long id, @RequestBody InstructorUpdateDTO updateInstructorDTO) {
        instructorService.update(id, updateInstructorDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
