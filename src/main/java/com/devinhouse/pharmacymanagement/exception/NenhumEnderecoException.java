package com.devinhouse.pharmacymanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Não existe nenhum endereço cadastrado!", value = HttpStatus.NOT_FOUND)
public class NenhumEnderecoException extends RuntimeException {
}
