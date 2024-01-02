package com.flipkartclone.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long orderId;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<Products> products;


}
