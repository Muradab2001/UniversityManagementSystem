package com.Evo.universitymanagementsystem.service;

import com.Evo.universitymanagementsystem.exception.CourseNotFoundException;
import com.Evo.universitymanagementsystem.exception.StudentNotFoundException;
import com.Evo.universitymanagementsystem.mapper.StudentMapper;
import com.Evo.universitymanagementsystem.repository.CourseRepository;
import com.Evo.universitymanagementsystem.repository.StudentRepository;
import com.Evo.universitymanagementsystem.repository.entity.Course;
import com.Evo.universitymanagementsystem.repository.entity.Student;
import com.Evo.universitymanagementsystem.service.dto.student.StudentCreateDTO;
import com.Evo.universitymanagementsystem.service.dto.student.StudentDTO;
import com.Evo.universitymanagementsystem.service.dto.student.StudentUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final CourseRepository courseRepository;

    public List<StudentDTO> findAll() {
        List<Student> students = studentRepository.findAllByIsDeleted(false);
        return studentMapper.toStudentDTOList(students);
    }

    public StudentDTO findById(Long id) {
        Student student = getStudent(id);
        return studentMapper.toStudentDTO(student);
    }

    public StudentDTO create(StudentCreateDTO createStudentDTO) {
        Student student = studentMapper.toStudent(createStudentDTO);
        Student createdStudent = studentRepository.save(student);
        return studentMapper.toStudentDTO(createdStudent);
    }

    public StudentDTO update(Long id, StudentUpdateDTO updateStudentDTO) {
        Student student = getStudent(id);
        studentMapper.toStudent(updateStudentDTO, student);
        Student updatedStudent = studentRepository.save(student);
        return studentMapper.toStudentDTO(updatedStudent);
    }

    public void deleteStudent(Long id) {
      Student student= getStudent(id);
      student.setDeleted(true);
      studentRepository.save(student);
    }

    public void enrollStudentToCourse(Long studentId, Long courseId) {
        Student student = getStudent(studentId);
        Course course = getCourse(courseId);

        student.getCourses().add(course);
        studentRepository.save(student);
    }

    private Student getStudent(Long id) {
        return studentRepository.findByIdAndIsDeleted(id,false)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id:" + id));
    }

    private Course getCourse(Long id) {
        return courseRepository.findByIdAndIsDeleted(id,false)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with id:" + id));
    }
}