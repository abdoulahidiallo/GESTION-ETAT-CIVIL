package com.gestionusers.service;

import com.gestionusers.entities.Role;

import java.util.List;

public interface RoleService {
    //
    Long createRole(Role role);
    List<Role> getAllRoles();
    Long editRole(Role role, Long id);
    Role showRole(Long id);
    void deleteRole(Long id);
    Role getOneRole(Long id);
    //
}
