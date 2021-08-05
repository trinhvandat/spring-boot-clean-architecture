package org.aibles.backend.student.delivery;

import org.aibles.backend.student.delivery.responses.SystemResponse;
import org.aibles.backend.shared.exceptions.BadRequestException;

public interface StudentControllerAdvice {

    SystemResponse<String> badRequestExceptionHandler(BadRequestException ex);

}
