package org.inventory.inventory.controller;

import org.inventory.inventory.dto.item;
import org.inventory.inventory.service.itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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





    // To get all items from the inventory database
    @GetMapping("/items")
    public ResponseEntity<Object> getAllItems(){
        return service.getAllItems();
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Object> getIemById(@PathVariable String id){
        return service.getItemById(id);
    }

    @GetMapping("/items/name/{name}")
    public ResponseEntity<Object> getItemByName(@PathVariable String name){
        return service.getItemByName(name);
    }

    @GetMapping("/items/{price1}/{price2}")
    public ResponseEntity<Object> getItemsByPrice(@PathVariable double price1, @PathVariable double price2){
        return service.getItemsByPrice(price1, price2);
    }










    @DeleteMapping("/items/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable String id){
        return service.deleteById(id);
    }







    @PatchMapping("/items/{id}")
    public ResponseEntity<Object> updateItem(@PathVariable String id, @RequestBody item item){
        return service.updateItem(id, item);
    }
}
