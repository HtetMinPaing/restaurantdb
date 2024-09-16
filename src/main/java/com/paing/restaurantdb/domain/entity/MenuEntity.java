package com.paing.restaurantdb.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "menu")
public class MenuEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_id_seq")
    private Long id;

    private String name;

    private String image;

    private String description;

    private Float price;

    private Boolean inDiscounted;

    private Float discountRate;

    private Boolean outOfStock;

    private Boolean trending;

    private Float stars;

    private String category;

}
