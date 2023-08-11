package com.sim.javamodule.domain.product.handler;

import com.sim.javamodule.domain.product.service.ProductService;
import com.sim.javamodule.domain.product.service.dto.ProductCreateRequest;
import com.sim.javamodule.domain.user.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class ProductHandler {
    private final ProductService productService;
    private final UserService userService;

    public ProductHandler(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    public void createProduct(ProductCreateRequest request){
        productService.saveProduct(request, userService::findByUsername, "test");
    }
}
