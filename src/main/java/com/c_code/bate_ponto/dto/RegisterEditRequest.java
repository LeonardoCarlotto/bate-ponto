package com.c_code.bate_ponto.dto;

import lombok.Data;

@Data
public class RegisterEditRequest {

    private Long registerId;
    private String observation;
    private String newRegistro;

}
