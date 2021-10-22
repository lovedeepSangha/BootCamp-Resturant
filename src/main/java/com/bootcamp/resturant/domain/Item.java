package com.bootcamp.resturant.domain;

import com.bootcamp.resturant.dto.ItemDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String ingredients;
    private Integer timeToPrepare;
    private Double price;


    public Item(ItemDTO itemDTO) {

        this.name = itemDTO.getName();
        this.ingredients = itemDTO.getIngredients();
        this.timeToPrepare = itemDTO.getTimeToPrepare();
        this.price = itemDTO.getPrice();
    }

}

