package com.example.userregistration.entity;

import com.example.userregistration.common.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "users")
public class AppUser extends BaseEntity {

    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 60)
    private String password;

    private String role;
    private boolean enabled = false;
}
