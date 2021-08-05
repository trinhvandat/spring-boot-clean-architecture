package org.aibles.backend.student.delivery.converters;

import org.aibles.backend.student.Student;
import org.aibles.backend.student.delivery.rest.dto.StudentDTO;
import org.aibles.backend.shared.RestDTOConverter;

public class StudentRestDTOConverter implements RestDTOConverter<StudentDTO, Student>{

    @Override
    public StudentDTO mapToDTO(Student entity) {
        return StudentDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .studentCode(entity.getStudentCode())
                .build();
    }

    @Override
    public Student mapToEntity(StudentDTO reqDTO) {
        return Student.builder()
                .id(reqDTO.getId())
                .name(reqDTO.getName())
                .studentCode(reqDTO.getStudentCode())
                .build();
    }
}
