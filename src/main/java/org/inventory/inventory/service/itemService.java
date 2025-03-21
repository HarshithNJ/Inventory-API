package org.inventory.inventory.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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










    public ResponseEntity<Object> getAllItems() {
        List<item> items = repository.findAll();

        if(items.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No items found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Items fetched successfully");
            map.put("items", items);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> getItemById(String id) {
        Optional<item> item = repository.findById(id);

        if(item.isPresent()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Item fetched successfully");
            map.put("item", item);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Item not found with the id :" + id);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> getItemByName(String name) {
        List<item> items = repository.findByName(name);

        if(items.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No items found with the name :" + name);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Items fetched successfully");
            map.put("items", items);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> getItemsByPrice(double price1, double price2) {
        List<item> items = repository.findByPriceBetween(price1, price2);

        if(items.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No items found with the price range between :" + price1 + " and " + price2);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Items fetched successfully");
            map.put("items", items);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }










    public ResponseEntity<Object> deleteById(String id) {
        Optional<item> item = repository.findById(id);

        if(item.isPresent()){
            repository.deleteById(id);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Item deleted successfully");
            map.put("item", item);

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Item not found with the id :" + id);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }










    public ResponseEntity<Object> updateItem(String id, item item) {
        Optional<item> item1 = repository.findById(id);

        if(item1.isPresent()){
            item i = item1.get();

            if(item.getName() != null)
                i.setName(item.getName());

            if(item.getPrice() != 0)
                i.setPrice(item.getPrice());

            if(item.getQuantity() != 0)
                i.setQuantity(item.getQuantity());

            if(item.getDescription() != null)
                i.setDescription(item.getDescription());
            
            repository.save(i);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Item updated successfully");
            map.put("item", i);

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Item not found with the id :" + id);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }
}
