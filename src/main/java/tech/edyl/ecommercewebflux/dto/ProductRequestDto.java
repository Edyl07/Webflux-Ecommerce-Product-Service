package tech.edyl.ecommercewebflux.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductRequestDto {
    private Integer id;
    private Integer categoryId;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private ProductStatus status;
}
