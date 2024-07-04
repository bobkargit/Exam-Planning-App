package com.bob.examplanning__.Repository;

import com.bob.examplanning__.Models.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Examen, Long> {
}
