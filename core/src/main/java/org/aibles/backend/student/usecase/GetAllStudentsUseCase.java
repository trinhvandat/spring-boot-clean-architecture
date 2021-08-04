package org.aibles.backend.student.usecase;

import org.aibles.backend.student.Student;

import java.util.Collection;

public interface GetAllStudentsUseCase {

    Collection<Student> execute();
}
