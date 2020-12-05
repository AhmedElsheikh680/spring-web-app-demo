package com.seniorsteps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.seniorsteps.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

	public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
