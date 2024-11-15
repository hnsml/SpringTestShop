package org.example.springshop.repositories;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.example.springshop.models.Shop;
import org.springframework.stereotype.Repository;

@Repository
public class ShopRepository {

    private final AtomicLong counter = new AtomicLong(0);
    private List<Shop> shops;

    @PostConstruct
    public void init() {
        shops = new ArrayList<>();
        shops.add(new Shop(counter.incrementAndGet(), "Grocery Store", "123 Main St", "555-1234",
                "contact@grocery.com", "http://grocery.com", "Grocery", "A local grocery store."));
        shops.add(new Shop(counter.incrementAndGet(), "Hardware Store", "456 Elm St", "555-5678",
                "contact@hardware.com", "http://hardware.com", "Hardware",
                "A hardware store with all your needs."));
        shops.add(new Shop(counter.incrementAndGet(), "Sports Store", "789 Oak St", "555-9012",
                "contact@sports.com", "http://sports.com", "Sports",
                "A store for all your sports equipment."));
    }

    public List<Shop> findAll() {
        return new ArrayList<>(shops);
    }

    public Optional<Shop> findById(Long id) {
        return shops.stream().filter(shop -> shop.getId().equals(id)).findFirst();
    }

    public Shop save(Shop shop) {
        shop.setId(counter.incrementAndGet());
        shops.add(shop);
        return shop;
    }

    public void delete(Long id) {
        shops.removeIf(store -> store.getId().equals(id));
    }


    public void update(Shop shop) {
        shops.stream().filter(s -> s.getId().equals(shop.getId())).findFirst()
                .ifPresent(s -> {
                    s.setName(shop.getName());
                    s.setAddress(shop.getAddress());
                    s.setEmail(shop.getEmail());
                    s.setPhone(shop.getPhone());
                    s.setWebsite(shop.getWebsite());
                    s.setCategory(shop.getCategory());
                    s.setDescription(shop.getDescription());
                });
    }

    public List<Shop> search(String query) {
        return shops.stream().filter(store -> store.getName().contains(query) ||
                        store.getCategory().contains(query) ||
                        store.getAddress().contains(query))
                .toList();
    }
}
