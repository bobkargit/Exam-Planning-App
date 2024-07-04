package com.bob.examplanning__.Repository;

import com.bob.examplanning__.Models.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, Long> {
}
