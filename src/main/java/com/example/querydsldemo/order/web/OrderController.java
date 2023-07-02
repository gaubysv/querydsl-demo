package com.example.querydsldemo.order.web;

import com.example.querydsldemo.order.domain.Order;
import com.example.querydsldemo.order.domain.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public Iterable<Order> getOrders(@ModelAttribute OrdersFilter filter) {
        return orderService.getOrders(filter);
    }
}
