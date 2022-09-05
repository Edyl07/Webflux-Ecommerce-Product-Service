package tech.edyl.ecommercewebflux.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Table("categories")
public class Category {

    @Id
    private Integer id;
    @Column("categoryName")
    private String categoryName;
    private String description;
    @Column("imageUrl")
    private String imageUrl;



}
