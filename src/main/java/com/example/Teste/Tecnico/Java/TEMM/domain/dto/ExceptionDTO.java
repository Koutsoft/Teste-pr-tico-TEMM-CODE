package com.example.Teste.Tecnico.Java.TEMM.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDTO {
    private String message;
    private String StatusCode;

}
