package org.example.springshop.repositories;

import java.util.List;
import org.example.springshop.models.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopSpringDataRepository extends CrudRepository<Shop, Long> {

    List<Shop> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name,
            String description);
}
