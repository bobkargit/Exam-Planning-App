package com.bob.examplanning__.Repository;

import com.bob.examplanning__.Models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
