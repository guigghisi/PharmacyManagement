package com.devinhouse.pharmacymanagement.service;

import com.devinhouse.pharmacymanagement.entity.EnderecoAPI;
import com.devinhouse.pharmacymanagement.entity.EnderecoCordenada;
import com.devinhouse.pharmacymanagement.entity.dto.EnderecoDto;
import com.devinhouse.pharmacymanagement.repository.EnderecoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoService {
    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    //TODO restTemplate

    public EnderecoDto buscaEnderecoViaCep(String cep) {

        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "https://viacep.com.br/ws/" + cep + "/json/";

        ResponseEntity<EnderecoAPI> response = restTemplate.getForEntity(resourceUrl, EnderecoAPI.class);
        EnderecoAPI enderecoAPI = response.getBody();

        var enderecodto = new EnderecoDto();
        enderecodto.setCep(enderecoAPI.getCep());
        enderecodto.setLogradouro(enderecoAPI.getLogradouro());
        enderecodto.setComplemento(enderecoAPI.getComplemento());
        enderecodto.setBairro(enderecoAPI.getBairro());
        enderecodto.setCidade(enderecoAPI.getLocalidade());
        enderecodto.setEstado(enderecoAPI.getUf());


        resourceUrl = "https://nominatim.openstreetmap.org/search?road=" + enderecoAPI.getLogradouro() + "&city=" + enderecoAPI.getLocalidade() + "&state=" + enderecoAPI.getUf() + "&country=brazil&format=json&addressdetails=1&limit=1&polygon_svg=1";
        ResponseEntity<EnderecoCordenada[]> cordenada = restTemplate.getForEntity(resourceUrl, EnderecoCordenada[].class);
        EnderecoCordenada[] enderecoCordenada = cordenada.getBody();

        enderecodto.setLatitude(enderecoCordenada[0].getLat());
        enderecodto.setLongitude(enderecoCordenada[0].getLon());

        return enderecodto;


    }


}
