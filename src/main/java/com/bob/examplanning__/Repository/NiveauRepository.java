package com.bob.examplanning__.Repository;

import com.bob.examplanning__.Models.Groupe;
import com.bob.examplanning__.Models.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NiveauRepository extends JpaRepository<Niveau,Long> {
}
