package org.inventory.inventory.service;

import org.inventory.inventory.repository.itemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class itemService {
    
    @Autowired
    itemRepository repository;
}
