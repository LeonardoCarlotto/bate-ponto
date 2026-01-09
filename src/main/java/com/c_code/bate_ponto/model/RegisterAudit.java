package com.c_code.bate_ponto.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "register_audit")
@Data
public class RegisterAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long registerId;

    private Long userId;

    @Column(length = 1000)
    private String oldData; // JSON ou texto formatado do registro original

    @Column(length = 1000)
    private String newData; // JSON ou texto formatado do registro editado

    @Column(length = 1000)
    private String observation;

    private LocalDateTime editedAt;

    private Long editedByUserId; // opcional, quem fez a edição

}
