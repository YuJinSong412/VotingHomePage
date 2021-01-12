package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.dto.UserDTO;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, Integer>{ 

}
