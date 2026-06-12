package com.example.demo.service;



import java.util.List;

import com.example.demo.entity.Brand;


public interface BrandService {

    Brand saveBrand(Brand brand);

    List<Brand> getAllBrands();
}