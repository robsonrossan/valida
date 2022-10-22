package br.com.desafio.iti.controller;

import br.com.desafio.iti.dto.SenhaStatusDTO;
import br.com.desafio.iti.service.ValidacaoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ValidacaoControllerTeste {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ValidacaoService validacaoService;

    private String url = "/iti/validacao/senha";

    @Test
    public void verificaSenhaUsandoRequestBodyComSenhaVazia() throws Exception {
        String requisicao = "{\"senha\": \"\"}";

        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
                .content(requisicao))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void verificaSenhaUsandoRequestBodySemAtributoSenha() throws Exception {
        String requisicao = "{\"qualquer\": \"12345\"}";

        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
                .content(requisicao))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void verificaSenhaUsandoRequestComSenhaValida() throws Exception {
        String requisicao = "{\"senha\": \"Senha!234*Ads\"}";

        Mockito.when(validacaoService.validarSenha(any())).thenReturn(SenhaStatusDTO.builder().senhaValida(true).build());

        ResultActions resultActions = mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
                .content(requisicao))
                .andExpect(status().isOk());

        MvcResult mvcResult = resultActions.andReturn();
        String content = mvcResult.getResponse().getContentAsString();

        assertEquals("{\"senhaValida\":true}", content);
    }

    @Test
    public void verificaSenhaUsandoRequestComSenhaInvalida() throws Exception {
        String requisicao = "{\"senha\": \"Senha12345\"}";

        Mockito.when(validacaoService.validarSenha(any())).thenReturn(SenhaStatusDTO.builder().senhaValida(false).build());

        ResultActions resultActions = mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
                .content(requisicao))
                .andExpect(status().isOk());

        MvcResult mvcResult = resultActions.andReturn();
        String content = mvcResult.getResponse().getContentAsString();

        assertEquals("{\"senhaValida\":false}", content);
    }
}
