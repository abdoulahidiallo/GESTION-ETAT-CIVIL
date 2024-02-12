package com.gestionusers.controllers;

import com.gestionusers.entities.Role;
import com.gestionusers.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RoleController {
    //
    private final RoleService roleService;
    //
    @GetMapping("")
    ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(this.roleService.getAllRoles());
    }
    //
    @GetMapping("/detail/{id}")
    ResponseEntity<Role> getDemandeById(@PathVariable("id") long id) {
        return ResponseEntity.ok(this.roleService.showRole(id));
    }
    //
    @PostMapping("/create")
    ResponseEntity<Long> saveDemade(@RequestBody @Validated Role role) {
        return ResponseEntity.ok(this.roleService.createRole(role));
    }
    //
    @PutMapping("/update/{id}")
    ResponseEntity<Long> updateDemande(@PathVariable("id") long id, @RequestBody @Validated Role role) {
        return ResponseEntity.ok(roleService.editRole(role, id));
    }
    //
    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteRole(@PathVariable("id") long id) {
        this.roleService.deleteRole(id);
        return ResponseEntity.accepted().build();
    }
//
}
