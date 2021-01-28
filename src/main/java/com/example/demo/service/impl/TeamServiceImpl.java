package com.example.demo.service.impl;

import com.example.demo.model.Team;
import com.example.demo.repository.TeamRepository;
import com.example.demo.service.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository teamRepository;


    @Override
    public Iterable<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team findUserById(Long id) {
        return teamRepository.findById(id).get();
    }

    @Override
    public Team save(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team update(Long id, Team team) {
        Optional<Team> oldTeam = teamRepository.findById(id);
        oldTeam.ifPresent(value -> {
            value.setName(team.getName());
            teamRepository.save(oldTeam.get());
        });
        return null;
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class})
    public boolean remove(Long id) {
        if (teamRepository.existsById(id)) {
            teamRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
