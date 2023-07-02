package com.example.querydsldemo.order.domain;

import com.example.querydsldemo.order.web.OrdersFilter;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Iterable<Order> getOrders(OrdersFilter filter) {
        QOrder order = QOrder.order;

        BooleanExpression predicate = order.bookIsbn.isNotNull();
        if (filter.getBookIsbn() != null) {
            predicate = predicate.and(order.bookIsbn.eq(filter.getBookIsbn()));
        }
        if (filter.getBookName() != null) {
            predicate = predicate.and(order.bookName.containsIgnoreCase(filter.getBookName()));
        }
        if (filter.getBookPriceFrom() != null) {
            predicate = predicate.and(order.bookPrice.goe(filter.getBookPriceFrom()));
        }
        if (filter.getBookPriceTo() != null) {
            predicate = predicate.and(order.bookPrice.loe(filter.getBookPriceTo()));
        }
        if (filter.getQuantityFrom() != null) {
            predicate = predicate.and(order.quantity.goe(filter.getQuantityFrom()));
        }
        if (filter.getQuantityTo() != null) {
            predicate = predicate.and(order.quantity.loe(filter.getQuantityTo()));
        }

        return orderRepository.findAll(predicate);
    }
}
