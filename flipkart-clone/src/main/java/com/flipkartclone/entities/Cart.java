package com.flipkartclone.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long cartId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("user")
    private Users user;

    @JsonIgnoreProperties("cart")
    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    private List<Products> products;

}
