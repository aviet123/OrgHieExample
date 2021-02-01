package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String role_name;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
}
