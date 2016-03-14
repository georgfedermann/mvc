package org.poormanscastle.studies.mvc.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.poormanscastle.studies.mvc.domain.Product;

/**
 * Created by georg on 26.11.15.
 */
public interface ProductRepository {

    List<Product> getAllProducts();

    Product getProductById(String productId);

    List<Product> getProductsByCategory(String category);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    void addProduct(Product product);

}
