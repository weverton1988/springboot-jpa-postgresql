package com.SpringBoot.JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SpringBoot.JPA.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
