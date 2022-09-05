package tech.edyl.ecommercewebflux.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Table("products")
public class Product {
    @Id
    private Integer id;
    @Column("categoryId")
    private Integer categoryId;
    private String name;
    private String description;
    private Double price;
    @Column("imageUrl")
    private String imageUrl;
}
