package com.sim.javamodule.domain.product.domain;

import com.sim.javamodule.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
public class Product {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String name;
    private Long cost;
    private Long quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private User productUploader;

    public Product() {
    }

    public Product(String name, Long cost, Long quantity, User productUploader) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
        this.productUploader = productUploader;
    }

    public void sellProduct(Long amount){
        if(quantity<=0)
            throw new IllegalArgumentException("품절된 상품입니다.");
        if(quantity<amount)
            throw new IllegalArgumentException("최대 "+quantity+"개만큼 구매가능합니다.");
        this.quantity-=amount;
    }

    public void updateQuantity(Long amount){
        this.quantity+=amount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCost() {
        return cost;
    }

    public Long getQuantity() {
        return quantity;
    }

    public User getProductUploader() {
        return productUploader;
    }
}
