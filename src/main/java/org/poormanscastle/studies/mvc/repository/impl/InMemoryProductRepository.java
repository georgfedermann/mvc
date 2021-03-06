package org.poormanscastle.studies.mvc.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.poormanscastle.studies.mvc.domain.Product;
import org.poormanscastle.studies.mvc.repository.ProductRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by georg on 26.11.15.
 */
@Repository
public class InMemoryProductRepository implements ProductRepository {

    private List<Product> listOfProducts = new ArrayList<>();

    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        Set<Product> result = new HashSet<>();
        Set<Product> productsByBrand = new HashSet<>();
        Set<Product> productsByCategory = new HashSet<>();
        Set<String> criterias = filterParams.keySet();
        if (criterias.contains("brand")) {
            for (String brandName : filterParams.get("brand")) {
                for (Product product : listOfProducts) {
                    if (brandName.equalsIgnoreCase(product.getManufacturer())) {
                        productsByBrand.add(product);
                    }
                }
            }
            result.addAll(productsByBrand);
        }
        if (criterias.contains("category")) {
            for (String category : filterParams.get("category")) {
                productsByCategory.addAll(getProductsByCategory(category));
            }
            result.retainAll(productsByCategory);
        }
        return result;
    }

    public InMemoryProductRepository() {
        Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
        iphone.setDescription("Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
        iphone.setCategory("Smart Phone");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);

        Product laptop_dell = new Product("P1235", "Dell Inspiron", new BigDecimal(700));
        laptop_dell.setDescription("Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors");
        laptop_dell.setCategory("Laptop");
        laptop_dell.setManufacturer("Dell");
        laptop_dell.setUnitsInStock(1000);

        Product tablet_Nexus = new Product("P1236", "Nexus 7", new BigDecimal(300));
        tablet_Nexus.setDescription("Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon™ S4 Pro processor");
        tablet_Nexus.setCategory("Tablet");
        tablet_Nexus.setManufacturer("Google");
        tablet_Nexus.setUnitsInStock(1000);

        listOfProducts.add(iphone);
        listOfProducts.add(laptop_dell);
        listOfProducts.add(tablet_Nexus);
    }

    @Override
    public List<Product> getAllProducts() {
        return listOfProducts;
    }

    @Override
    public Product getProductById(String productId) {
        for (Product product : listOfProducts) {
            if (product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
                return product;
            }
        }
        throw new IllegalArgumentException(StringUtils.join("No products found for the product id: ", productId));
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product product : listOfProducts) {
            if (category.equalsIgnoreCase(product.getCategory())) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public void addProduct(Product product) {
        listOfProducts.add(product);
    }
}
