package com.dc.restfulwebservices.springboot.user.repository;

import com.dc.restfulwebservices.springboot.user.bean.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRespository extends JpaRepository<Post, Integer> {
}
