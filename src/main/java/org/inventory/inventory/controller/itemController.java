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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class itemController {
    
    @Autowired
    itemService service;

    // To save a item in the inventory database
    @Operation(summary = "Save an item in the inventory database", description = "Save an item in the inventory database")
    @ApiResponse(responseCode = "201", description = "Item saved successfully")
    @ApiResponse(responseCode = "400", description = "Price and Quantity must be greater than 0")
    @ApiResponse(responseCode = "226", description = "Item id Already exists")
    @PostMapping("/items")
    public ResponseEntity<Object> saveItem(@RequestBody item item){
        return service.saveItem(item);
    }





    // To get all items from the inventory database
    @Operation(summary = "Get all items from the inventory database", description = "Get all items from the inventory database")
    @ApiResponse(responseCode = "302", description = "Returns all items from the inventory database")
    @ApiResponse(responseCode = "404", description = "No items found")
    @GetMapping("/items")
    public ResponseEntity<Object> getAllItems(){
        return service.getAllItems();
    }

    @Operation(summary = "Get an item from the inventory database", description = "Get an item By Id from the inventory database")
    @ApiResponse(responseCode = "302", description = "Returns an item By id from the inventory database")
    @ApiResponse(responseCode = "404", description = "Item not found")
    @GetMapping("/items/{id}")
    public ResponseEntity<Object> getIemById(@PathVariable String id){
        return service.getItemById(id);
    }

    @Operation(summary = "Get an item from the inventory database", description = "Get an item By Name from the inventory database")
    @ApiResponse(responseCode = "302", description = "Returns an item By name from the inventory database")
    @ApiResponse(responseCode = "404", description = "Item not found")
    @GetMapping("/items/name/{name}")
    public ResponseEntity<Object> getItemByName(@PathVariable String name){
        return service.getItemByName(name);
    }

    @Operation(summary = "Get an item from the inventory database", description = "Get an item By Price Range from the inventory database")
    @ApiResponse(responseCode = "302", description = "Returns an item By price range from the inventory database")
    @ApiResponse(responseCode = "404", description = "Item not found")
    @GetMapping("/items/{price1}/{price2}")
    public ResponseEntity<Object> getItemsByPrice(@PathVariable double price1, @PathVariable double price2){
        return service.getItemsByPrice(price1, price2);
    }










    @Operation(summary = "Delete an item from the inventory database", description = "Delete an item By Id from the inventory database")
    @ApiResponse(responseCode = "200", description = "Item deleted successfully")
    @ApiResponse(responseCode = "404", description = "Item not found")
    @DeleteMapping("/items/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable String id){
        return service.deleteById(id);
    }







    @Operation(summary = "Update an item from the inventory database", description = "Update an item By Id from the inventory database")
    @ApiResponse(responseCode = "200", description = "Item updated successfully")
    @ApiResponse(responseCode = "404", description = "Item not found")
    @PatchMapping("/items/{id}")
    public ResponseEntity<Object> updateItem(@PathVariable String id, @RequestBody item item){
        return service.updateItem(id, item);
    }
}
