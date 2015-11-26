package org.poormanscastle.studies.mvc.repository;

import org.poormanscastle.studies.mvc.domain.Product;

import java.util.List;

/**
 * Created by georg on 26.11.15.
 */
public interface ProductRepository {

    List<Product> getAllProducts();

}
