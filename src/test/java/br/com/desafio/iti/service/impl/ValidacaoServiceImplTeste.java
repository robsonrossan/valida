package br.com.desafio.iti.service.impl;

import br.com.desafio.iti.dto.SenhaDTO;
import br.com.desafio.iti.dto.SenhaStatusDTO;
import br.com.desafio.iti.regra.Regra;
import br.com.desafio.iti.regra.impl.RegraQtdeCaracteresImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ValidacaoServiceImplTeste {

    private List<Regra> regrasValidacao;

    private ValidacaoServiceImpl validacaoService;

    @BeforeEach
    private void inicializar() {
        regrasValidacao = Arrays.asList(new RegraQtdeCaracteresImpl());
        validacaoService = new ValidacaoServiceImpl(regrasValidacao);
    }

    @Test
    public void verificarSenhaUsandoValorValido() {
        SenhaDTO senhaDTO = new SenhaDTO();
        senhaDTO.setSenha("Senh@12ASs%");
        SenhaStatusDTO senhaStatusDTO = validacaoService.validarSenha(senhaDTO);
        assertTrue(senhaStatusDTO.isSenhaValida());
        assertNull(senhaStatusDTO.getMensagemErro());
    }

    @Test
    public void verificarSenhaUsandoValorInvalido() {
        SenhaDTO senhaDTO = new SenhaDTO();
        senhaDTO.setSenha("Senh@1");
        SenhaStatusDTO senhaStatusDTO = validacaoService.validarSenha(senhaDTO);
        assertFalse(senhaStatusDTO.isSenhaValida());
        assertEquals("Senha precisa ter 9 caracteres no minimo", senhaStatusDTO.getMensagemErro());
    }
}
