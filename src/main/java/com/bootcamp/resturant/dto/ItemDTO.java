package com.bootcamp.resturant.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {


    private String name;
    private String ingredients;
    private Integer timeToPrepare;
    private Double price;


}
