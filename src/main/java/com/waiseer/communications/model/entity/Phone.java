package com.waiseer.communications.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "phones")

public class Phone {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phoneId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn/*(name = "client_id", nullable = false)*/
    private Client client;

    private String phoneNumber;
}
