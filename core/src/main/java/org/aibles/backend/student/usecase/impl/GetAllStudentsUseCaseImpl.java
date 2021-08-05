package org.aibles.backend.student.usecase.impl;

import lombok.AllArgsConstructor;
import org.aibles.backend.student.Student;
import org.aibles.backend.student.ports.StudentRepositoryService;
import org.aibles.backend.student.usecase.GetAllStudentsUseCase;

import java.util.Collection;

@AllArgsConstructor
public class GetAllStudentsUseCaseImpl implements GetAllStudentsUseCase {

    private final StudentRepositoryService studentService;

    @Override
    public Collection<Student> execute() {
        return studentService.getAllStudents();
    }
}
