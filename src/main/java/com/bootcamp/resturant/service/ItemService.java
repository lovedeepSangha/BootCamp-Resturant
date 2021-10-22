package com.bootcamp.resturant.service;

import com.bootcamp.resturant.domain.Item;
import com.bootcamp.resturant.dto.ItemDTO;
import com.bootcamp.resturant.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item addItemInMenu(ItemDTO itemDTO) {
        return itemRepository.save(new Item(itemDTO));
    }

    public void deleteItemInMenu(Integer itemId) {
        itemRepository.deleteById(itemId);
    }

    public Item updateItemInMenu(Integer itemId, ItemDTO itemDTO) {
        var item = itemRepository.findById(itemId);
        if (item.isPresent()) {
            itemRepository.save(updateItemDetails(item.orElseThrow(), itemDTO));
        }
        return itemRepository.save(new Item(itemDTO));
    }

    private Item updateItemDetails(Item item, ItemDTO itemDTO) {
        item.setIngredients(itemDTO.getIngredients());
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        item.setTimeToPrepare(itemDTO.getTimeToPrepare());
        return item;
    }

    public Optional<Item> findItemById(Integer itemId) {
        return itemRepository.findById(itemId);
    }
}
