package org.aibles.backend.student.delivery;

import org.aibles.backend.student.delivery.rest.dto.StudentDTO;
import org.aibles.backend.student.delivery.responses.SystemResponse;

import java.util.Collection;

public interface StudentController {

    SystemResponse<Collection<StudentDTO>> getStudents();

    SystemResponse<StudentDTO> createStudent(final StudentDTO student);
}
