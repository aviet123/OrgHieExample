package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;

    @OneToMany
    private List<Role> roles;
}
