package com.bob.examplanning__.Repository;

import com.bob.examplanning__.Models.ElementPedago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementRepository extends JpaRepository<ElementPedago, Long> {
}
