package com.Evo.universitymanagementsystem.mapper;

import com.Evo.universitymanagementsystem.repository.entity.Department;
import com.Evo.universitymanagementsystem.service.dto.department.CreateDepartmentDTO;
import com.Evo.universitymanagementsystem.service.dto.department.DepartmentDTO;
import com.Evo.universitymanagementsystem.service.dto.department.UpdateDepartmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = InstructorMapper.class)
public interface DepartmentMapper {

    DepartmentDTO toDepartmentDTO(Department department);

    Department toDepartment(CreateDepartmentDTO createDepartmentDTO);

    void toDepartment(UpdateDepartmentDTO updateDepartmentDTO, @MappingTarget Department department);

    List<DepartmentDTO> toDepartmentDTOList(List<Department> departmentList);
}


