package org.aibles.backend.student.configuration;

import lombok.RequiredArgsConstructor;
import org.aibles.backend.student.delivery.converters.StudentRestDTOConverter;
import org.aibles.backend.student.persistence.converters.StudentRepositoryConverter;
import org.aibles.backend.student.persistence.impl.StudentServiceIml;
import org.aibles.backend.student.persistence.repositories.StudentRepository;
import org.aibles.backend.student.usecase.CreateStudentUseCase;
import org.aibles.backend.student.usecase.GetAllStudentsUseCase;
import org.aibles.backend.student.usecase.impl.CreateStudentUseCaseImpl;
import org.aibles.backend.student.usecase.impl.GetAllStudentsUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class have all configuration bean of student infrastructure
 */
@Configuration
@RequiredArgsConstructor
public class StudentConfiguration {

    private final StudentRepository studentRepository;

    @Bean
    public StudentRestDTOConverter createStudentRestDTOConverter(){
        return new StudentRestDTOConverter();
    }

    @Bean
    public StudentRepositoryConverter createStudentRepositoryConverter(){
        return new StudentRepositoryConverter();
    }

    @Bean
    public StudentServiceIml createStudentService(){
        return new StudentServiceIml(studentRepository, createStudentRepositoryConverter());
    }

    @Bean
    public CreateStudentUseCase createCreateStudentUseCase(){
        return new CreateStudentUseCaseImpl(createStudentService());
    }

    @Bean
    public GetAllStudentsUseCase createGetAllStudentsUseCase(){
        return new GetAllStudentsUseCaseImpl(createStudentService());
    }

}
