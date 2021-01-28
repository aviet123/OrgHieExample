package com.example.demo;

import com.example.demo.model.Team;
import com.example.demo.service.service.OrgService;
import com.example.demo.service.service.TeamService;
import com.example.demo.service.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class TestTransactional {

    @Mock
    OrgService orgService;

    @Mock
    TeamService teamService;

    @Mock
    UserService userService;

    @Test
    public void TestTransactionalOfRemoveMethod(){
        Mockito.doThrow(new NullPointerException()).when(teamService).remove(1L);
        Mockito.doReturn(true).when(userService).remove(1L);
        userService.remove(1L);
        teamService.remove(1L);
        Assert.assertFalse(userService.remove(1L));
    }
}
