package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String leaderShip;

    @OneToMany
    private List<Team> teams;
}
