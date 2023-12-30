package com.flipkartclone.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long productId;
    private String productName;
    private String productDescription;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnoreProperties("order")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;


}

