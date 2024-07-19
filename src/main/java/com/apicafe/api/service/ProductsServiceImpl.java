package com.apicafe.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicafe.api.models.Products;
import com.apicafe.api.repository.ProductsRepository;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    ProductsRepository productRepository;

    @Override
    public Optional<Products> findById(Integer id) {

        return productRepository.findById(id);
    }

    @Override
    public List<Products> findAll() {

        return productRepository.findAll();
    }

    @Override
    public Products save(Products product) {

        return productRepository.save(product);
    }

    @Override
    public void deletById(Integer id) {
        productRepository.deleteById(id);
    }

}
