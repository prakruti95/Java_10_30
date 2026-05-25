package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Mobile;

public interface MobileRepository extends JpaRepository<Mobile, Integer> {

}