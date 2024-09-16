package com.paing.restaurantdb.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuDto {

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
