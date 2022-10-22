package br.com.desafio.iti.regra.impl;

import br.com.desafio.iti.regra.exception.RegraEspacoEmBrancoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class RegraEspacoEmBrancoImplTeste {

    private RegraEspacoEmBrancoImpl regraEspacoEmBranco = new RegraEspacoEmBrancoImpl();

    @Test
    public void verificarSenhaSemEspacoEmBranco() {
        assertAll(() -> regraEspacoEmBranco.validarRegra("abcd"));
    }

    @Test
    public void verificarSenhaComEspacoEmBranco() {
        assertThrows(RegraEspacoEmBrancoException.class, () -> regraEspacoEmBranco.validarRegra("ab cd"));
    }
}
