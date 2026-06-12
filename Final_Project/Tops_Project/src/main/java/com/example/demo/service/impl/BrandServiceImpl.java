package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Brand;
import com.example.demo.repository.BrandRepository;
import com.example.demo.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository repo;

    @Override
    public Brand saveBrand(Brand brand) {
        return repo.save(brand);
    }

    @Override
    public List<Brand> getAllBrands() {
        return repo.findAll();
    }
}