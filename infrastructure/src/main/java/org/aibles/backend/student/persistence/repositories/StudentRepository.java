package org.aibles.backend.student.persistence.repositories;

import org.aibles.backend.student.persistence.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    Optional<StudentEntity> findByStudentCode(String studentCode);
}
