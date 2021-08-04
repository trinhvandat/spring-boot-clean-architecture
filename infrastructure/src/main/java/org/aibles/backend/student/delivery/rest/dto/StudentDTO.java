package org.aibles.backend.student.delivery.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    @Length(max = 10)
    private String studentCode;
}
