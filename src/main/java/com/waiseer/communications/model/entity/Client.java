package com.waiseer.communications.model.entity;


import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "clients")

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    private String name;

   /* @OneToMany
    private List<Phone> phones;

    @OneToMany
    private List<Email> emails;*/
}
