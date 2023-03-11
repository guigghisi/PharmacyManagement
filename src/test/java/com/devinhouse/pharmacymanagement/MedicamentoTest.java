package com.devinhouse.pharmacymanagement;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestEntityManager
// Caso queira observar o compartamento do teste no banco de dados desative @Transactional
// Com @Transaction ativado os testes não fazem alteração do estado dos registros no banco de dados
// Sempre após finalizado o teste transação rodará um RollBack voltando o estado do registro(s) no banco
@Transactional
public class MedicamentoTest {

    private URI path;
    private MockHttpServletRequest request;
    private ResultMatcher expectedResult;

    @Autowired
    private MockMvc mock;

    private String jwtToken;

    @Before
    public void setUp() throws Exception {

        String json = "{\"email\": \"ghisi@ghisi.com\", \"senha\": \"1010\"}";

        path = new URI("/auth");
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(path)
                .contentType(MediaType.APPLICATION_JSON).content(json);

        expectedResult = MockMvcResultMatchers.status().isOk();
        String response = mock.perform(request).andExpect(expectedResult).andReturn().getResponse()
                .getContentAsString();

        JSONObject data = new JSONObject(response);

        jwtToken = data.getString("Authorization");
    }

    @Test
    public void testeCadastro() throws Exception {
        String jsonCadastro = "{\"nome_medicamento\": \"testeMedicamento\", \"nome_laboratorio\": \"testeMedicamento\", \"dosagem_medicamento\": \"testeMedicamento\", \"descricao_medicamento\": \"testeMedicamento\", \"preco_unitario\": \"45\", \"tipo_medicamento\": \"testeMedicamento\"}";
        path = new URI("/medicamento");
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(path)
                .content(jsonCadastro)
                .header("Content-Type", "application/json")
                .header("Authorization", jwtToken);

        expectedResult = MockMvcResultMatchers.status().isCreated();

        mock.perform(request).andExpect(expectedResult);
    }

    @Test
    public void testeAtualizar() throws Exception{

    }
}
