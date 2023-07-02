package com.example.querydsldemo;

import com.example.querydsldemo.order.domain.Order;
import com.example.querydsldemo.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
@Profile("testdata")
@RequiredArgsConstructor
public class OrderDataLoader {

    private final OrderRepository orderRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadTestOrdersData() {
        orderRepository.deleteAll();

        var order1 = Order.builder()
                .bookName("Northern Lights")
                .bookIsbn("1234567891")
                .bookPrice(29.99)
                .quantity(2)
                .createdDate(Instant.now())
                .build();

        var order2 = Order.builder()
                .bookName("Polar Journey")
                .bookIsbn("1234567892")
                .bookPrice(43.74)
                .quantity(5)
                .createdDate(Instant.now())
                .build();

        orderRepository.saveAll(List.of(order1, order2));
    }
}
