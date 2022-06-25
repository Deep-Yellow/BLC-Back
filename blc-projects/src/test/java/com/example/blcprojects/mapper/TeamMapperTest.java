package com.example.blcprojects.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeamMapperTest {

    @Autowired
    TeamMapper teamMapper;

    @Test
    void getTagNameById() {
        System.out.println(teamMapper.getTeamById(1));
    }
}