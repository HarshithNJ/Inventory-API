package org.inventory.inventory.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class item {

    @Id
    private String id;

    private String name;
    private long quantity;
    private double price;
    private String description;
    
}
