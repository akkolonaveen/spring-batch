package com.naveen.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naveen.batch.model.User;

public interface UserRepository  extends JpaRepository<User, Integer>{

}
