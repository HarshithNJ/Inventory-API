package org.inventory.inventory.repository;

import java.util.List;

import org.inventory.inventory.dto.item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface itemRepository extends JpaRepository<item, String> {

    List<item> findByName(String name);

}
