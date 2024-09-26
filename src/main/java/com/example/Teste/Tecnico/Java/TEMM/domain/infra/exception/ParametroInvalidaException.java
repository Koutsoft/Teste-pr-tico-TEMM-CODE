package com.example.Teste.Tecnico.Java.TEMM.domain.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ParametroInvalidaException{

@ExceptionHandler(EntityNotFoundException.class)
public ResponseEntity entidadeNaoEncontrada (EntityNotFoundException exception){
   // ExceptionDTO exceptionDTO = new ExceptionDTO("nao encontrado", "404");

    return ResponseEntity.notFound().build();

}



}
