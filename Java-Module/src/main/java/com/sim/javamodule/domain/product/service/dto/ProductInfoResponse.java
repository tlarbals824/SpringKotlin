package com.sim.javamodule.domain.product.service.dto;

import com.sim.javamodule.domain.product.domain.Product;
import lombok.Getter;

public record ProductInfoResponse(String name, Long cost, Long quantity) {
    public static ProductInfoResponse mapProductToProductInfoResponse(final Product product){
        return new ProductInfoResponse(product.getName(), product.getCost(), product.getQuantity());
    }
}
