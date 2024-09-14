package com.example.mscreditmanager.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class CreditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int term;
    BigDecimal interest;
    BigDecimal monthlyPayment;
    BigDecimal amount;
    BigDecimal requestedAmount;
    String status;
    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    CustomerEntity customer;
    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL)
    Set<OfferEntity> offers;
    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL)
    Set<StatusHistoryEntity> statusHistoryEntities;
}
