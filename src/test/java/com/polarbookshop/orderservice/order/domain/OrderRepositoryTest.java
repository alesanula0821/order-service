package com.polarbookshop.orderservice.order.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.test.context.ActiveProfiles;
import reactor.test.StepVerifier;


@DataR2dbcTest
@Import(TestDatabaseConfiguration.class)
@EnableR2dbcAuditing
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration")
class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private R2dbcEntityTemplate template;

    @Test
    void findOrderByIdTest() {
        var orderId = 1L;
        var order = new Order(orderId, "76434567890", "New book", 15.45, 3, OrderStatus.ACCEPTED, null, null, 0);
        orderRepository.save(order).subscribe();

        StepVerifier.create(orderRepository.findById(orderId)).expectNextCount(1L).verifyComplete();
    }
}