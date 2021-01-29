package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Team {

    @Id
    @Column(nullable = false)
    private Long id;
    private String name;

    @ManyToOne
    @NotEmpty
    @NotNull
    private Organization organization;

    @OneToMany
    @NotEmpty
    @NotNull
    private List<User> users;
}
