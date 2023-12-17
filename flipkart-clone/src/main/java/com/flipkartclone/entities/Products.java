package com.flipkartclone.entities;


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
    private Orders order;


}

