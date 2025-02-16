package org.inventory.inventory.controller;

import org.inventory.inventory.service.itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class itemController {
    
    @Autowired
    itemService service;
}
