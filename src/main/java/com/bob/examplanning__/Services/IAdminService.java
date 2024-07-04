package com.bob.examplanning__.Services;

import com.bob.examplanning__.Models.Admin;
import com.bob.examplanning__.Models.ElementPedago;

import java.util.List;

public interface IAdminService {
    public void addAdmin(Admin admin);

    public void updateAdmin(Admin admin);

    public List<Admin> getAllAdmins();

    public void deleteAdmin(Long id);

    public Admin getAdminById(Long id);
}
