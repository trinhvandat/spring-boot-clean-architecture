package org.aibles.backend.student.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "student")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity implements Serializable {

    private static final Long serialVersionUID = 23423424243L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "student_code", unique = true)
    private String studentCode;

    @CreationTimestamp
    @Column(name = "created_date")
    private Instant createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private Instant updatedDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentEntity)) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
