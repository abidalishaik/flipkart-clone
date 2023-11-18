package com.flipkartclone.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long userId;

    private String userName;

    private String password;

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private List<Orders> orders;

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private List<Products> products;

}
