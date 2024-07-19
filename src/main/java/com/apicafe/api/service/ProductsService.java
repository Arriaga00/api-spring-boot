package com.apicafe.api.service;

import java.util.Optional;
import java.util.List;
import com.apicafe.api.models.Products;

public interface ProductsService {

    public Optional<Products> findById(Integer id);

    public List<Products> findAll();

    public Products save(Products product);

    public void deletById(Integer id);

}
