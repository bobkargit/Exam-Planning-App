package com.bob.examplanning__.Services.Impl;

import com.bob.examplanning__.Models.Admin;
import com.bob.examplanning__.Repository.AdminRepository;
import com.bob.examplanning__.Services.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements IAdminService {

    private final AdminRepository adminRepository;
   // private PasswordEncoder passwordEncoder;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

  /* @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }*/

    @Override
    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public void updateAdmin(Admin admin) {
        Admin existingAdmin = getAdminById(admin.getId());

        if(existingAdmin != null) {
            existingAdmin.setPrenom(admin.getPrenom());
            existingAdmin.setNom(admin.getNom());
            adminRepository.save(existingAdmin);
        } else {
            throw new RuntimeException("Admin not found with ID: " + admin.getId());
        }
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    /*public Boolean verifyLoginInfo(String email, String password) {
        Admin admin = adminRepository.findByEmailAndPassword(email, password);
        return admin != null;
    }*/
    public Boolean verifyLoginInfo(String email, String password) {
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null) {
            return password.equals(admin.getPassword());
        }
        return false;
    }
}
