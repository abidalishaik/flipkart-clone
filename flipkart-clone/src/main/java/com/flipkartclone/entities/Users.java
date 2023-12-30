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
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long userId;
    private String userName;
    private String password;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders order;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Cart cart;


}
