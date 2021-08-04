package org.aibles.backend.student.persistence.converters;

import org.aibles.backend.student.Student;
import org.aibles.backend.student.persistence.entities.StudentEntity;
import org.aibles.backend.student.shared.RepositoryConverter;

public class StudentRepositoryConverter implements RepositoryConverter<StudentEntity, Student> {

    @Override
    public StudentEntity mapToTable(Student persistenceObject) {
        return StudentEntity.builder()
                .name(persistenceObject.getName())
                .studentCode(persistenceObject.getStudentCode())
                .build();
    }

    @Override
    public Student mapToEntity(StudentEntity tableObject) {
        return Student.builder()
                .id(tableObject.getId())
                .name(tableObject.getName())
                .studentCode(tableObject.getStudentCode())
                .build();
    }
}
