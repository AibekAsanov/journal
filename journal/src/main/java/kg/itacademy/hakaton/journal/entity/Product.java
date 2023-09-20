package kg.itacademy.hakaton.journal.entity;

import jakarta.persistence.*;
import kg.itacademy.hakaton.journal.enums.Categories;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_of_product;

    @Column(name = "name_of_product")
    private String name_of_product;

    @Column(name = "price_of_product")
    private Integer price_of_product;

    @Column(name = "quantity_of_product")
    private Integer quantity_of_product;

    @Column(name = "category_of_product")
    private Categories category_of_product;
}
