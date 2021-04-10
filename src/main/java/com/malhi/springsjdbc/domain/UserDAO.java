package com.malhi.springsjdbc.domain;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDAO {
    private JdbcTemplate jdbcTemplate;

    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void readAndWrite(){
        String sql = "select * from batch30";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        users.forEach(System.out::println);
    }

    public int addUser(User user){
        String sql = "Insert Into batch30 values(?,?,?)";
        return jdbcTemplate.update(sql, user.getId(), user.getFirstName(), user.getLastName());
    }

    public int updateUser(User user){
        String sql = "Update batch30 set lastName = ? where Id = ?";
        return jdbcTemplate.update(sql, user.getLastName(), user.getId());
    }

   public User findById(int id){
        String sql = "select * from batch30 where Id = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),id);
   }

   public List<Integer> findAllByLastName(String lastName){
        String sql = "select id from batch30 where lastName = ?";
        return jdbcTemplate.queryForList(sql,Integer.class,lastName);
   }
}
