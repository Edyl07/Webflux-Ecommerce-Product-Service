package tech.edyl.ecommercewebflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.edyl.ecommercewebflux.dto.CategoryDto;
import tech.edyl.ecommercewebflux.dto.ProductRequestDto;
import tech.edyl.ecommercewebflux.dto.ProductResponseDto;
import tech.edyl.ecommercewebflux.dto.ProductStatus;
import tech.edyl.ecommercewebflux.repository.CategoryRepository;
import tech.edyl.ecommercewebflux.repository.ProductRepository;
import tech.edyl.ecommercewebflux.utils.EntityDtoUtil;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Mono<ProductResponseDto> createProduct(final ProductRequestDto requestDto){
        return this.categoryRepository
                .findById(requestDto.getCategoryId())
                .map(b -> EntityDtoUtil.toEntity(requestDto))
                .flatMap(this.productRepository::save)
                .map(p -> EntityDtoUtil.toDto(requestDto, ProductStatus.ACTIVE))
                .defaultIfEmpty(EntityDtoUtil.toDto(requestDto, ProductStatus.INACTIVE));
    }


    public Flux<ProductResponseDto> all(){
        return this.productRepository
                .findAll()
                .map(EntityDtoUtil::productResponseDto);
    }
}