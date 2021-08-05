package org.aibles.backend.student.usecase.impl;

import lombok.AllArgsConstructor;
import org.aibles.backend.student.exceptions.StudentCodeAlreadyExistsException;
import org.aibles.backend.student.Student;
import org.aibles.backend.student.ports.StudentRepositoryService;
import org.aibles.backend.student.usecase.CreateStudentUseCase;

@AllArgsConstructor
public class CreateStudentUseCaseImpl implements CreateStudentUseCase {

    private final StudentRepositoryService studentRepositoryService;

    @Override
    public Student execute(Student student) throws StudentCodeAlreadyExistsException{
        if (!studentRepositoryService.doesStudentCodeExists(student.getStudentCode())){
            return studentRepositoryService.saveStudent(student);
        }
        else {
            throw new StudentCodeAlreadyExistsException();
        }
    }
}
