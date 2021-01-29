package com.example.demo.controller;

import com.example.demo.model.Organization;
import com.example.demo.model.Team;
import com.example.demo.service.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping("")
    public Iterable<Team> getAllTeam(){
        return teamService.findAll();
    }

    @PostMapping("")
    public ResponseEntity<Team> createTeam(@Valid @RequestBody Team team){
        Team teamCreated = teamService.save(team);
        return new ResponseEntity<Team>(teamCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long id, @RequestBody Team newTeam) throws Exception {
        Team team = teamService.update(id, newTeam);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Team> deleteTeam(@PathVariable Long id){
        teamService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
