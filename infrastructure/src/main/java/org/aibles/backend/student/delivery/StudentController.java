package org.aibles.backend.student.delivery;

import org.aibles.backend.student.delivery.rest.dto.StudentDTO;
import org.aibles.backend.student.delivery.responses.SystemResponse;
import org.aibles.backend.shared.exceptions.BadRequestException;

import java.util.Collection;

public interface StudentController {

    SystemResponse<Collection<StudentDTO>> getStudents();

    SystemResponse<StudentDTO> createStudent(final StudentDTO student) throws BadRequestException;
}
