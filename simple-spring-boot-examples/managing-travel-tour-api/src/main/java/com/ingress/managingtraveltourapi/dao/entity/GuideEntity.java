package com.ingress.managingtraveltourapi.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Set;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class GuideEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    String phoneNumber;
    LocalDateTime availableFrom;
    LocalDateTime availableTo;
    @ManyToMany(mappedBy = "guideEntities",cascade = CascadeType.ALL)
    Set<TourEntity> tourEntities;
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    PassportEntity passportEntity;
}
