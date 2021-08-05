package org.aibles.backend.student.usecase;

import org.aibles.backend.student.exceptions.StudentCodeAlreadyExistsException;
import org.aibles.backend.student.Student;

public interface CreateStudentUseCase {

    Student execute(Student student) throws StudentCodeAlreadyExistsException;
}
