package com.flipkartclone.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long productId;

    private String productName;

    private String productDescription;

    @Lob
    private byte[] productImage;

    @ManyToOne
    private Orders orderId;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH
    }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_product",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "productId"))
    private List<Users> users;
}

