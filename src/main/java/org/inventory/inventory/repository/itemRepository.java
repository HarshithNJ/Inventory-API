package org.inventory.inventory.repository;

import org.inventory.inventory.dto.item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface itemRepository extends JpaRepository<item, String> {

}
