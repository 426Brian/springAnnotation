package com.sprAnnotation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void insert() {
        String sql = "insert into employee values (6, 'jdbcTemplate','age.@email', 1, 2)";

        int update = jdbcTemplate.update(sql);
        int a = 1/0;
        System.out.println("inser num = " + update);
    }
}
