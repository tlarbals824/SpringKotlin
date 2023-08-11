package com.sim.javamodule;

import com.sim.javamodule.domain.order.handler.OrderHandler;
import com.sim.javamodule.domain.order.service.dto.OrderCreateRequest;
import com.sim.javamodule.domain.product.domain.Product;
import com.sim.javamodule.domain.product.domain.ProductRepository;
import com.sim.javamodule.domain.product.service.ProductService;
import com.sim.javamodule.domain.user.domain.Credit;
import com.sim.javamodule.domain.user.domain.CreditRepository;
import com.sim.javamodule.domain.user.service.CreditService;
import com.sim.javamodule.domain.user.service.UserService;
import jakarta.annotation.security.RolesAllowed;
import org.assertj.core.api.Assertions;
import org.hibernate.internal.log.SubSystemLogging;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@SpringBootTest
class JavaModuleApplicationTests {

    @Autowired
    private OrderHandler orderHandler;
    @Autowired
    private CreditService creditService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;


    @Transactional
    @BeforeEach
    void init(){
        Credit credit = creditService.findByUserId(userService::findById, 1L);
        credit.minusCredit(credit.getCreditAmount());
        credit.plusCredit(1000000L);

        Product product = productService.findById(1L);
        product.sellProduct(product.getQuantity());
        product.updateQuantity(100L);
    }

    @Test
    void orderTest() throws InterruptedException {
        //given
        int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        //when
        for(int i=0;i<threadCount;i++){
            executorService.submit(() -> {
                try{
                    orderHandler.orderProduct(new OrderCreateRequest(1L, 1L));
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        //then
        Credit credit = creditService.findByUserId(userService::findById, 1L);
        Product product = productService.findById(1L);
        Assertions.assertThat(credit.getCreditAmount()).isEqualTo(0);
        Assertions.assertThat(product.getQuantity()).isEqualTo(0);
    }
}
