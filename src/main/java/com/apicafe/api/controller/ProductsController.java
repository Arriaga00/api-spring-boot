package com.apicafe.api.controller;

import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apicafe.api.models.Products;
import com.apicafe.api.service.ProductsService;

@RestController
@RequestMapping("api/products")
public class ProductsController {

    @Autowired
    ProductsService productService;

    @GetMapping("/{id}")
    public Optional<Products> consultarPorId(@PathVariable Integer id) {
        return productService.findById(id);
    }

    @GetMapping("/listProducts")
    public List<Products> listarProducts() {
        return productService.findAll();
    }

    @PostMapping("/saveProduct")
    public Products creaProducts(@RequestBody Products product) {
        product.setId(product.getId());
        product.setName(product.getName());
        product.setDescription(product.getDescription());
        product.setPrice(product.getPrice());
        product.setImage(product.getImage());

        return productService.save(product);
    }

    @PutMapping("/update/{id}")
    public Products actualizarProducts(@PathVariable Integer id, @RequestBody Products product) {
        Products productExistente = productService.findById(id)
                .orElseThrow(() -> new RuntimeException("Product no encontrado"));
        productExistente.setName(product.getName());
        productExistente.setDescription(product.getDescription());
        productExistente.setPrice(product.getPrice());
        productExistente.setImage(product.getImage());

        return productService.save(productExistente);
    }

    @DeleteMapping("deleteProduct/{id}")
    public void eliminarProduct(@PathVariable Integer id) {
        productService.deletById(id);
    }

}
