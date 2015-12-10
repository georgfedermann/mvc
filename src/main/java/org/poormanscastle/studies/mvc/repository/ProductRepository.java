package org.poormanscastle.studies.mvc.repository;

import org.poormanscastle.studies.mvc.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by georg on 26.11.15.
 */
public interface ProductRepository {

    List<Product> getAllProducts();

    Product getProductById(String productId);

    List<Product> getProductsByCategory(String category);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

}
