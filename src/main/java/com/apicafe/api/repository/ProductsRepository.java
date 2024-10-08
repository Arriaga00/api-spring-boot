package com.apicafe.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apicafe.api.models.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
