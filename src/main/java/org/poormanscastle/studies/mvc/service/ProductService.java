package org.poormanscastle.studies.mvc.service;

import org.poormanscastle.studies.mvc.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by georg on 26.11.15.
 */
public interface ProductService {

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    Product getProductById(String productId);

}
