package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Mobile;

public interface MobileRepository extends JpaRepository<Mobile, Integer> {

    List<Mobile> findByModelContainingIgnoreCase(String model);

    List<Mobile> findByBrand_BrandNameContainingIgnoreCase(String brand);

    List<Mobile> findByCategory_CategoryNameContainingIgnoreCase(String category);

}