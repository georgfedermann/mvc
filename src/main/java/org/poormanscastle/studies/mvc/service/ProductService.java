package org.poormanscastle.studies.mvc.service;

import java.util.List;

import org.poormanscastle.studies.mvc.domain.Product;

/**
 * Created by georg on 26.11.15.
 */
public interface ProductService {

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

}
