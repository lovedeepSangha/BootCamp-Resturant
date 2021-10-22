package com.bootcamp.resturant.controller;

import com.bootcamp.resturant.domain.Item;
import com.bootcamp.resturant.dto.ItemDTO;
import com.bootcamp.resturant.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private ItemService itemService;


    @GetMapping
    public List<Item> Menu() {
        return itemService.getAllItems();
    }



    @PostMapping
    public Item addItemInMenu(@RequestBody ItemDTO itemDTO){
        return itemService.addItemInMenu(itemDTO);
    }

    @DeleteMapping
    public void deleteItemInMenu(@RequestParam Integer itemId){
         itemService.deleteItemInMenu(itemId);
    }



    @PutMapping
    public Item updateItemInMenu(@RequestParam Integer itemId,@RequestBody ItemDTO itemDTO){
        return itemService.updateItemInMenu(itemId,itemDTO);
    }



}
