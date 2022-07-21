package com.example.springbootupload.dto.command;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class FoodCreateCommand implements Serializable {
    private String name;
    private String description;
    private Float preparedTime;
    private Float price;
    private String image;
}
