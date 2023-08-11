package com.sim.javamodule.domain.product.service.dto;

import com.sim.javamodule.domain.product.domain.Product;
import lombok.Getter;

public record ProductSimpleInfoResponse(Long productId, String name, Long cost) {
    public static ProductSimpleInfoResponse mapProductToProductSimpleInfoResponse(final Product product){
        return new ProductSimpleInfoResponse(product.getId(), product.getName(), product.getCost());
    }
}
