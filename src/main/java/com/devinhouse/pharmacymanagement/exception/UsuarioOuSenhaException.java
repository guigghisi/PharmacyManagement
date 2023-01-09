package com.devinhouse.pharmacymanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Usuário ou senha incorreto!", value = HttpStatus.NOT_FOUND)

public class UsuarioOuSenhaException extends RuntimeException {
}
