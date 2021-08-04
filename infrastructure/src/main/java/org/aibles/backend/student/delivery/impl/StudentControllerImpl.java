package org.aibles.backend.student.delivery.impl;

import lombok.AllArgsConstructor;
import org.aibles.backend.student.Student;
import org.aibles.backend.student.delivery.StudentController;
import org.aibles.backend.student.delivery.responses.SystemResponse;
import org.aibles.backend.student.delivery.rest.dto.StudentDTO;
import org.aibles.backend.student.shared.RestDTOConverter;
import org.aibles.backend.student.shared.constant.CommonConstants;
import org.aibles.backend.student.shared.constant.RestConstants;
import org.aibles.backend.student.usecase.CreateStudentUseCase;
import org.aibles.backend.student.usecase.GetAllStudentsUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(RestConstants.API_PATH + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_STUDENT)
@AllArgsConstructor
public class StudentControllerImpl implements StudentController {

    private final GetAllStudentsUseCase getAllStudentsUseCase;
    private final CreateStudentUseCase createStudentUseCase;
    private final RestDTOConverter<StudentDTO, Student> studentRestDTOConverter;

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public SystemResponse<Collection<StudentDTO>> getStudents() {
        final Collection<StudentDTO> studentDTOs = getAllStudentsUseCase.execute()
                .stream()
                .map(student -> studentRestDTOConverter.mapToDTO(student)).collect(Collectors.toList());

        return SystemResponse.<Collection<StudentDTO>>builder()
                .status(CommonConstants.SUCCESS)
                .code(String.valueOf(HttpStatus.OK.value()))
                .message(CommonConstants.OK)
                .data(studentDTOs)
                .build();
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public SystemResponse<StudentDTO> createStudent(@Validated() @RequestBody StudentDTO student) {
        final Student createdStudent = createStudentUseCase.execute(studentRestDTOConverter.mapToEntity(student));

        return SystemResponse.<StudentDTO>builder()
                .status(CommonConstants.SUCCESS)
                .code(String.valueOf(HttpStatus.CREATED.value()))
                .message(CommonConstants.OK)
                .data(studentRestDTOConverter.mapToDTO(createdStudent))
                .build();
    }
}
