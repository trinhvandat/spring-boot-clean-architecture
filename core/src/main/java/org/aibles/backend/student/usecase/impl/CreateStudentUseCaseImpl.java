package org.aibles.backend.student.usecase.impl;

import lombok.AllArgsConstructor;
import org.aibles.backend.student.Student;
import org.aibles.backend.student.ports.StudentService;
import org.aibles.backend.student.usecase.CreateStudentUseCase;

@AllArgsConstructor
public class CreateStudentUseCaseImpl implements CreateStudentUseCase {

    private final StudentService studentService;

    @Override
    public Student execute(Student student) {
        return studentService.saveStudent(student);
    }
}
