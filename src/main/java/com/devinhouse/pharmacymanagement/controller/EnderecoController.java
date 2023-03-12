package com.devinhouse.pharmacymanagement.controller;

import com.devinhouse.pharmacymanagement.entity.dto.EnderecoDto;
import com.devinhouse.pharmacymanagement.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping("/cep/{cep}")
    @ResponseStatus(HttpStatus.OK)
    public EnderecoDto consultaCep(@PathVariable(value = "cep") String cep) {
        return enderecoService.buscaEnderecoViaCep(cep);
    }
}
