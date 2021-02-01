package com.example.demo.controller;

import com.example.demo.model.Organization;
import com.example.demo.model.User;
import com.example.demo.service.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/org")
public class OrgController {

    @Autowired
    OrgService orgService;

    @GetMapping("")
    public Iterable<Organization> getAllOrg(){
        return orgService.findAll();
    }

    @PostMapping("")
    public ResponseEntity<Organization> createOrg(@RequestBody Organization organization){
        Organization organizationCreated = orgService.save(organization);
        return new ResponseEntity<Organization>(organizationCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Organization> updateOrg(@PathVariable Long id, @RequestBody Organization newOrganization) throws Exception {
        Organization organization = orgService.update(id, newOrganization);
        return new ResponseEntity<>(organization, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Organization> deleteOrg(@PathVariable Long id){
        orgService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
