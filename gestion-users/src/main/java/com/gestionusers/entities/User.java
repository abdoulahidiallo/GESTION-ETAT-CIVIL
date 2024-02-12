package com.gestionusers.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username")
})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
    //
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String prenom;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(nullable = true, length = 50)
    private String contact;

    @Column(nullable = true, length = 50)
    private String email;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
    public void addRole(Role role) {
        this.roles.add(role);
    }
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "prenom", length = 50)
//    private String prenom;
//
//    @Column(name = "nom", length = 50)
//    private String nom;
//
//    @Column(name = "contact", length = 50, nullable = true)
//    private String contact;
//
//    @Column(name = "username", length = 50)
//    private String username;
//
//    @Column(name = "password", length = 100)
//    private String password;
//
//    @ManyToOne
//    private Role role;

}
