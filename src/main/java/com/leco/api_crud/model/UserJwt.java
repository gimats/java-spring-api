package com.leco.api_crud.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data //User lombok for get/set
public class UserJwt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password; //save password already hash
}
