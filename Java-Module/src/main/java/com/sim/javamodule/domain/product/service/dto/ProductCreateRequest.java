package com.sim.javamodule.domain.product.service.dto;

import com.sim.javamodule.domain.product.domain.Product;

public record ProductCreateRequest(String name, Long cost, Long quantity) {
}
