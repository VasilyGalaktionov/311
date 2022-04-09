package com.example.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.sidorov.springbootdemo.model.User;

public interface UserRepository extends CrudRepository<User,Integer> {

}