package org.aibles.backend.student.ports;

import org.aibles.backend.student.Student;

import java.util.Collection;

public interface StudentRepositoryService {

    Collection<Student> getAllStudents();

    Student saveStudent(Student student);

    Boolean doesStudentExists(Integer studentId);

    Boolean doesStudentCodeExists(String studentCode);
}
