package org.poormanscastle.studies.mvc.controller;

import org.poormanscastle.studies.mvc.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

/**
 * Created by georg on 25.11.15.
 */
@Controller
public class ProductController {

    @RequestMapping("/products")
    public String list(Model model){
        Product iphone = new Product("P1234", "iPhone 5S", new BigDecimal(500));
        iphone.setDescription("Apple iPhone 5S smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
        iphone.setCategory("Smart Phone");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);

        model.addAttribute("product", iphone);

        return "products";
    }

}
