package com.sim.javamodule.domain.order.handler;

import com.sim.javamodule.domain.order.domain.Order;
import com.sim.javamodule.domain.order.service.OrderService;
import com.sim.javamodule.domain.order.service.dto.OrderCreateRequest;
import com.sim.javamodule.domain.product.domain.Product;
import com.sim.javamodule.domain.product.service.ProductService;
import com.sim.javamodule.domain.user.domain.Credit;
import com.sim.javamodule.domain.user.domain.User;
import com.sim.javamodule.domain.user.service.CreditService;
import com.sim.javamodule.domain.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

@Transactional
@Component
public class OrderHandler {
    private final OrderService orderService;
    private final ProductService productService;
    private final UserService userService;
    private final CreditService creditService;

    private static final Logger log = Logger.getLogger(OrderHandler.class.getName());

    public OrderHandler(OrderService orderService, ProductService productService, UserService userService, CreditService creditService) {
        this.orderService = orderService;
        this.productService = productService;
        this.userService = userService;
        this.creditService = creditService;
    }

    /**
     * 1. 상품 수량 검사
     * <br> 2. 사용자 크레딧 검사
     * <br> 3. 크레딧 감소
     * <br> 4. 주문 생성
     * @param request
     */
    public void orderProduct(OrderCreateRequest request){
        final Credit credit = creditService.findByUserId(userService::findById, 1L);
        final Product product = productService.findById(request.productId());
        final Long totalAmount = request.quantity()*product.getCost();
        creditService.minusCredit(credit, totalAmount);
        productService.sellProduct(product, request.quantity());
        log.info("credit: "+credit.getCreditAmount());
        log.info("product: "+product.getQuantity());
        final User user = userService.findById(1L);
        orderService.saveOrder(new Order(request.quantity(), user, product));
    }
}
