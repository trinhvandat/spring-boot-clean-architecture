package org.aibles.backend.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.aibles.backend.shared.SelfValidating;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
public class Student extends SelfValidating<Student> implements Serializable {

    @NotNull
    @Min(0)
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    @Length(max = 10)
    private String studentCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
