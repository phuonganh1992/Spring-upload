package com.example.springbootupload.dto.view;

import com.example.springbootupload.domain.Food;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class FoodView implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Float preparedTime;
    private Float price;
    private String image;

    public static FoodView from(Food domain){
        return FoodView.builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .price(domain.getPrice())
                .image(domain.getImage())
                .build();
    }
}
