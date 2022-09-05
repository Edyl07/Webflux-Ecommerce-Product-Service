package tech.edyl.ecommercewebflux.utils;

import org.springframework.beans.BeanUtils;
import tech.edyl.ecommercewebflux.dto.CategoryDto;
import tech.edyl.ecommercewebflux.dto.ProductRequestDto;
import tech.edyl.ecommercewebflux.dto.ProductResponseDto;
import tech.edyl.ecommercewebflux.dto.ProductStatus;
import tech.edyl.ecommercewebflux.entity.Category;
import tech.edyl.ecommercewebflux.entity.Product;

public class EntityDtoUtil {

    public static CategoryDto toDto(Category category){
        CategoryDto dto = new CategoryDto();
        BeanUtils.copyProperties(category, dto);

        return dto;
    }

    public static ProductResponseDto productResponseDto(Product product){
        ProductResponseDto dto = new ProductResponseDto();
        BeanUtils.copyProperties(product, dto);

        return dto;
    }


    public static Category toEntity(CategoryDto dto){
        Category category = new Category();
        BeanUtils.copyProperties(dto, category);

        return category;
    }


    public static Product toEntity(ProductRequestDto requestDto){
        Product product = new Product();
        product.setId(requestDto.getId());
        product.setCategoryId(requestDto.getCategoryId());
        product.setName(requestDto.getName());
        product.setDescription(requestDto.getDescription());
        product.setPrice(requestDto.getPrice());
        product.setImageUrl(requestDto.getImageUrl());

        return product;
    }

    public static ProductResponseDto toDto(ProductRequestDto requestDto, ProductStatus status){
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(requestDto.getId());
        responseDto.setName(requestDto.getName());
        responseDto.setCategoryId(requestDto.getCategoryId());
        responseDto.setDescription(requestDto.getDescription());
        responseDto.setPrice(requestDto.getPrice());
        responseDto.setImageUrl(requestDto.getImageUrl());
        responseDto.setStatus(status);

        return responseDto;
    }
}
