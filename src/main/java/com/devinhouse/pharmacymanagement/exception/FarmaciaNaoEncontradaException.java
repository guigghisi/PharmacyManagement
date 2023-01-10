package com.devinhouse.pharmacymanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Farmacia não encontrada!", value = HttpStatus.NOT_FOUND)
public class FarmaciaNaoEncontradaException extends RuntimeException {
}
