package com.Evo.universitymanagementsystem.mapper;

import com.Evo.universitymanagementsystem.repository.entity.Instructor;
import com.Evo.universitymanagementsystem.service.dto.instructor.InstructorCreateDTO;
import com.Evo.universitymanagementsystem.service.dto.instructor.InstructorDTO;
import com.Evo.universitymanagementsystem.service.dto.instructor.InstructorUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    InstructorDTO toInstructorDTO(Instructor instructor);

    List<InstructorDTO> toInstructorDTOList(List<Instructor> instructors);


    Instructor toInstructor(InstructorCreateDTO createInstructorDTO);

    void toInstructor(InstructorUpdateDTO updateInstructorDTO, @MappingTarget Instructor instructor);
}