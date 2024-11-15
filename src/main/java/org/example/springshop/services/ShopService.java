package org.example.springshop.services;

import java.util.List;
import java.util.Optional;
import org.example.springshop.models.Shop;
import org.example.springshop.repositories.ShopSpringDataRepository;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

    private final ShopSpringDataRepository shopSpringDataRepository;

    public ShopService(ShopSpringDataRepository shopSpringDataRepository) {
        this.shopSpringDataRepository = shopSpringDataRepository;
    }

    public List<Shop> getAllShops() {
        return (List<Shop>) shopSpringDataRepository.findAll();
    }

    public Optional<Shop> getShopById(Long id) {
        return shopSpringDataRepository.findById(id);
    }

    public Shop addShop(Shop shop) {
        return shopSpringDataRepository.save(shop);
    }

    public void updateShop(Shop shop) {
        shopSpringDataRepository.save(shop);
    }

    public void deleteShop(Long id) {
        shopSpringDataRepository.deleteById(id);
    }

    public List<Shop> searchShops(String query) {
        return shopSpringDataRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
                query, query);
    }
}
