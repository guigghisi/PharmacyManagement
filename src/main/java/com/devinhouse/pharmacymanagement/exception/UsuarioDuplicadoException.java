package com.devinhouse.pharmacymanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Já existe um usuário com este email!", value = HttpStatus.CONFLICT)
public class UsuarioDuplicadoException extends RuntimeException {
}
