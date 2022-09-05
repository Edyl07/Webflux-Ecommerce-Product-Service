package tech.edyl.ecommercewebflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.edyl.ecommercewebflux.dto.CategoryDto;
import tech.edyl.ecommercewebflux.repository.CategoryRepository;
import tech.edyl.ecommercewebflux.utils.EntityDtoUtil;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Flux<CategoryDto> all(){
        return this.categoryRepository
                .findAll()
                .map(EntityDtoUtil::toDto);
    }


    public Mono<CategoryDto> getCategoryById(final int categoryId){
        return this.categoryRepository
                .findById(categoryId)
                .map(EntityDtoUtil::toDto);
    }

    public Mono<CategoryDto> createCategory(Mono<CategoryDto> categoryDtoMono){
        return categoryDtoMono
                .map(EntityDtoUtil::toEntity)
                .flatMap(this.categoryRepository::save)
                .map(EntityDtoUtil::toDto);
    }

    public Mono<CategoryDto> updateCategory(int id, Mono<CategoryDto> categoryDtoMono){
        return this.categoryRepository
                .findById(id)
                .flatMap(c -> categoryDtoMono
                        .map(EntityDtoUtil::toEntity)
                        .doOnNext(e -> e.setId(id)))
                .flatMap(this.categoryRepository::save)
                .map(EntityDtoUtil::toDto);
    }


    public  Mono<Void> deleteCategory(int id){
        return this.categoryRepository.deleteById(id);
    }
}
