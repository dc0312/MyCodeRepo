package com.dc.restfulwebservices.springboot.user.repository;

import com.dc.restfulwebservices.springboot.user.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
