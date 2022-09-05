package tech.edyl.ecommercewebflux.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import tech.edyl.ecommercewebflux.entity.Category;

@Repository
public interface CategoryRepository extends ReactiveCrudRepository<Category, Integer> {


    @Query("SELECT * FROM categories WHERE id = :categoryId")
    Mono<Boolean> findMyCategory(int categoryId);
}
