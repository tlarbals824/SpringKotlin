package com.sim.javamodule.domain.order.domain;

import com.sim.javamodule.domain.product.domain.Product;
import com.sim.javamodule.domain.user.domain.User;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    private Long orderQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private User orderUser;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product orderProduct;


    protected Order() {
    }

    public Order(Long orderQuantity, User orderUser, Product orderProduct) {
        this.orderQuantity = orderQuantity;
        this.orderUser = orderUser;
        this.orderProduct = orderProduct;
    }

    public Long getId() {
        return id;
    }

    public Long getOrderQuantity() {
        return orderQuantity;
    }

    public User getOrderUser() {
        return orderUser;
    }

    public Product getOrderProduct() {
        return orderProduct;
    }
}
