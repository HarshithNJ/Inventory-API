package org.inventory.inventory.service;

import java.util.HashMap;
import java.util.Map;

import org.inventory.inventory.dto.item;
import org.inventory.inventory.repository.itemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class itemService {
    
    @Autowired
    itemRepository repository;

    public ResponseEntity<Object> saveItem(item item) {
        if(repository.existsById(item.getId())){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Item id Already exists");

            return new ResponseEntity<Object>(map, HttpStatus.IM_USED);
        }else if(item.getPrice() <= 0 || item.getQuantity() <= 0){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Price and Quantity must be greater than 0");

            return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
        }else{
            repository.save(item);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Item saved successfully");
            map.put("item", item);

            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        }
    }
}
