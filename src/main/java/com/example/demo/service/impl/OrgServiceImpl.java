package com.example.demo.service.impl;

import com.example.demo.model.Organization;
import com.example.demo.repository.OrganizationRepository;
import com.example.demo.service.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    OrganizationRepository orgRepository;

    @Override
    public Iterable<Organization> findAll() {
        return orgRepository.findAll();
    }

    @Override
    public Organization findUserById(Long id) {
        return orgRepository.findById(id).get();
    }

    @Override
    public Organization save(Organization organization) {
        return orgRepository.save(organization);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Organization update(Long id, Organization organization) throws Exception{
        Optional<Organization> oldOrg = orgRepository.findById(id);
        if (oldOrg.isPresent()){
            oldOrg.get().setName(organization.getName());
            oldOrg.get().setLeaderShip(organization.getLeaderShip());
            throw new MyException();
        }
        return null;
    }
    static class MyException extends Exception {
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class})
    public boolean remove(Long id) {
        if (orgRepository.existsById(id)) {
            orgRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
