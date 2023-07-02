package com.example.querydsldemo.order.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Data
@Entity
@Builder
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date", nullable = false)
    private Instant createdDate;

    @Column(name = "book_isbn", nullable = false)
    private String bookIsbn;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_price")
    private Double bookPrice;

    @Column(nullable = false)
    private Integer quantity;
}
