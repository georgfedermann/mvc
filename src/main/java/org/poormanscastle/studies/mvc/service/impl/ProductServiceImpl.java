package org.poormanscastle.studies.mvc.service.impl;

import java.util.List;

import org.poormanscastle.studies.mvc.domain.Product;
import org.poormanscastle.studies.mvc.repository.ProductRepository;
import org.poormanscastle.studies.mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by georg on 26.11.15.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.getProductsByCategory(category);
    }
}
