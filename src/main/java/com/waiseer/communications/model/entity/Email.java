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
@Table(name = "emails")
public class Email {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    private String emailAddress;
}
