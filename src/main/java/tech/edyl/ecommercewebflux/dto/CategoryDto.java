package tech.edyl.ecommercewebflux.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CategoryDto {

    private Integer id;
    private String categoryName;
    private String description;
    private String imageUrl;


}
