package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Team {

    @Id
    @Column(nullable = false)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "organization_id",nullable = false)
    @JsonManagedReference
    private Organization organization;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<User> users;
}
