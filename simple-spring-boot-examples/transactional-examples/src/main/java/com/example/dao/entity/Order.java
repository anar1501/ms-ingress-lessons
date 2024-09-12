package com.example.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "\"order\"")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String description;
    String title;
}
