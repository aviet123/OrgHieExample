package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotNull
    @NotEmpty
    private List<Team> teams;
}
