package com.project.two.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity<Long> {

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;
    private String nationalCode;

}
