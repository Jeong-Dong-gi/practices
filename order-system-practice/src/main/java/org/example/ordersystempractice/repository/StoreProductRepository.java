package org.example.ordersystempractice.repository;

import org.example.ordersystempractice.domain.StoreProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StoreProductRepository extends CrudRepository<StoreProduct, Integer> {
    Optional<StoreProduct> findByStoreIdAndProductId(int storeId, int productId);
}
