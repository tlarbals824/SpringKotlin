package com.sim.javamodule.domain.product.controller;

import com.sim.javamodule.domain.product.handler.ProductHandler;
import com.sim.javamodule.domain.product.service.ProductService;
import com.sim.javamodule.domain.product.service.dto.ProductCreateRequest;
import com.sim.javamodule.domain.product.service.dto.ProductInfoResponse;
import com.sim.javamodule.domain.product.service.dto.ProductSimpleInfoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final ProductHandler productHandler;

    public ProductController(ProductService productService, ProductHandler productHandler) {
        this.productService = productService;
        this.productHandler = productHandler;
    }

    @GetMapping("/{productId}")
    public ProductInfoResponse getProduct(@PathVariable Long productId){
        return productService.getProductById(productId);
    }

    @GetMapping
    public Page<ProductSimpleInfoResponse> getAllProduct(@RequestParam int size, @RequestParam int page){
        return productService.getAllProduct(PageRequest.of(page, size));
    }

    @PostMapping
    public void createProduct(@RequestBody ProductCreateRequest request){
        productHandler.createProduct(request);
    }
}
