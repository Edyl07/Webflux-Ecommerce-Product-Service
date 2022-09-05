package tech.edyl.ecommercewebflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import tech.edyl.ecommercewebflux.entity.Product;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {
}
