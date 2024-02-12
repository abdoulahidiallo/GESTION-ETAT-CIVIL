package com.gestionusers.service;

import com.gestionusers.entities.Role;
import com.gestionusers.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceIMPL implements RoleService{
    //
    private final RoleRepository roleRepository;
    //
    @Override
    public Long createRole(Role role) {
        return this.roleRepository.save(role).getId();
    }

    @Override
    public List<Role> getAllRoles() {
        return this.roleRepository.findAll();
    }

    @Override
    public Long editRole(Role role, Long id) {
        //
        Optional<Role> roleAMettreAjourOptional = null;
        roleAMettreAjourOptional = this.roleRepository.findById(id);
        if (roleAMettreAjourOptional.isPresent()) {
            Role roleAMettreAjour = roleAMettreAjourOptional.get();
            roleAMettreAjour.setName(role.getName());
            roleAMettreAjour.setDescription(role.getDescription());
            return this.roleRepository.save(roleAMettreAjour).getId();
        } else {
            return Long.valueOf(0);
        }
        //
    }

    @Override
    public Role showRole(Long id) {
        //
        Optional<Role> roleOptional = this.roleRepository.findById(id);
        if (roleOptional.isEmpty()){
            return null;
        }
        return roleOptional.get();
        //
    }

    @Override
    public void deleteRole(Long id) {
        //
        this.roleRepository.deleteById(id);
        //
    }

    @Override
    public Role getOneRole(Long id) {
        //
        Optional<Role> roleOptional = this.roleRepository.findById(id);
        if (roleOptional.isEmpty()){
            return null;
        }
        return roleOptional.get();
        //
    }
}
