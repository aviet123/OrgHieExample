package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany
    private List<User> users;
}
