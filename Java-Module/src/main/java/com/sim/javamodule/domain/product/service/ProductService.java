package com.sim.javamodule.domain.product.service;

import com.sim.javamodule.domain.product.domain.Product;
import com.sim.javamodule.domain.product.domain.ProductRepository;
import com.sim.javamodule.domain.product.service.dto.ProductCreateRequest;
import com.sim.javamodule.domain.product.service.dto.ProductInfoResponse;
import com.sim.javamodule.domain.product.service.dto.ProductSimpleInfoResponse;
import com.sim.javamodule.domain.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Transactional
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductInfoResponse getProductById(final Long id){
        final Product product = findById(id);
        return ProductInfoResponse.mapProductToProductInfoResponse(product);
    }

    public Page<ProductSimpleInfoResponse> getAllProduct(Pageable pageable){
        final Page<Product> allProduct = productRepository.findAll(pageable);
        return allProduct.map(ProductSimpleInfoResponse::mapProductToProductSimpleInfoResponse);
    }

    public void saveProduct(ProductCreateRequest request, Function<String, User> findUser, String username){
        final User user = findUser.apply(username);
        productRepository.save(new Product(request.name(), request.cost(), request.quantity(), user));
    }

    public Product findById(final Long id){
        return productRepository.findProduct(id)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));
    }

    public void sellProduct(Product product, Long quantity){
        product.sellProduct(quantity);
        productRepository.saveAndFlush(product);
    }
}
