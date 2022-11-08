package com.example.springalishev.bootProject.reposirories;

import com.example.springalishev.bootProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {





}
