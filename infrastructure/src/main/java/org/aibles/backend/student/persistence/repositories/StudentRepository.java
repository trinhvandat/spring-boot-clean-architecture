package org.aibles.backend.student.persistence.repositories;

import org.aibles.backend.student.persistence.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}
