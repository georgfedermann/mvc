package org.poormanscastle.studies.mvc.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.poormanscastle.studies.mvc.domain.Product;
import org.poormanscastle.studies.mvc.repository.ProductRepository;
import org.poormanscastle.studies.mvc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by georg on 26.11.15.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final static Logger logger = Logger.getLogger(OrderServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void processOrder(String productId, int quantity) {
        logger.info(StringUtils.join("Got a request for ", quantity, " piece(s) of product ", productId));
        Product product = productRepository.getProductById(productId);
        logger.debug(StringUtils.join("Found product ", product));
        if (product.getUnitsInStock() < quantity) {
            throw new IllegalArgumentException(StringUtils.join("Out of Stock. Available units in stock: ", product.getUnitsInStock()));
        }

        product.setUnitsInStock(product.getUnitsInStock() - quantity);
    }

}
