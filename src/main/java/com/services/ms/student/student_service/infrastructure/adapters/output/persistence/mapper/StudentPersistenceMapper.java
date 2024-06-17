package com.services.ms.student.student_service.infrastructure.adapters.output.persistence.mapper;

import com.services.ms.student.student_service.domain.model.Student;
import com.services.ms.student.student_service.infrastructure.adapters.output.persistence.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentPersistenceMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "address", source = "address")
    StudentEntity toStudentEntity(Student student);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "address", source = "address")
    Student toStudent(StudentEntity studentEntity);

    List<Student> toStudents(List<StudentEntity> studentEntities);
}
