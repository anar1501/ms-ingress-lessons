package com.ingress.managingtraveltourapi.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "passport")
public class PassportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String passportNumber;
    LocalDateTime issueDate;
    LocalDateTime expiryDate;
    String country;
    @OneToOne(mappedBy = "passportEntity")
    GuideEntity guideEntity;
}
