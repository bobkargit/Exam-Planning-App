package com.bob.examplanning__.Repository;

import com.bob.examplanning__.Models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

   //Admin findByEmailAndPassword(String email, String password);
   Admin findByEmail(String email);
}
