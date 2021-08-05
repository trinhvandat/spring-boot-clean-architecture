package org.aibles.backend.student.persistence.impl;

import lombok.AllArgsConstructor;
import org.aibles.backend.student.Student;
import org.aibles.backend.student.persistence.entities.StudentEntity;
import org.aibles.backend.student.persistence.repositories.StudentRepository;
import org.aibles.backend.student.ports.StudentRepositoryService;
import org.aibles.backend.shared.RepositoryConverter;

import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
public class StudentServiceIml implements StudentRepositoryService {

    private final StudentRepository studentRepository;
    private final RepositoryConverter<StudentEntity, Student> studentRepositoryConverter;

    @Override
    public Collection<Student> getAllStudents() {
        final Collection<StudentEntity> studentEntities = studentRepository.findAll();
        return studentEntities
                .stream()
                .map(studentEntity -> studentRepositoryConverter.mapToEntity(studentEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Student saveStudent(Student student) {
        StudentEntity studentEntityReq = studentRepositoryConverter.mapToTable(student);
        studentEntityReq.setId(null);
        return studentRepositoryConverter.mapToEntity(studentRepository.save(studentEntityReq));
    }

    @Override
    public Boolean doesStudentExists(Integer studentId) {
        return studentRepository.findById(studentId)
                .map(studentEntity -> {
                    return true;
                })
                .orElse(false);
    }

    @Override
    public Boolean doesStudentCodeExists(String studentCode) {
        return studentRepository.findByStudentCode(studentCode)
                .map(studentEntity -> {
                    return true;
                })
                .orElse(false);
    }
}
