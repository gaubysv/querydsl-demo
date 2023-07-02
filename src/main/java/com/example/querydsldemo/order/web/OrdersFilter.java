package com.example.querydsldemo.order.web;

import lombok.Data;

@Data
public class OrdersFilter {

    private String bookIsbn;
    private String bookName;
    private Double bookPriceFrom;
    private Double bookPriceTo;
    private Integer quantityFrom;
    private Integer quantityTo;
}
