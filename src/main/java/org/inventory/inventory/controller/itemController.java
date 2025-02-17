package org.inventory.inventory.controller;

import org.inventory.inventory.dto.item;
import org.inventory.inventory.service.itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class itemController {
    
    @Autowired
    itemService service;

    // To save a item in the inventory database
    @PostMapping("/items")
    public ResponseEntity<Object> saveItem(@RequestBody item item){
        return service.saveItem(item);
    }
}
