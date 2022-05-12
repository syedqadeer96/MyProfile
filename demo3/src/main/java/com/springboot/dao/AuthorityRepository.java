package com.springboot.dao;

import com.springboot.entity.Authority;
import com.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
