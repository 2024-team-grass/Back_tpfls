package com.contest.grass.controller;

import ch.qos.logback.core.model.Model;
import com.contest.grass.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {

    private final ItemRepository itemRepository;
    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/item")
    String item(Model model) {
        itemRepository.findAll();

        return "item.html";
    }
}
