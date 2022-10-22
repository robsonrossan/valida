package br.com.desafio.iti.regra.impl;

import br.com.desafio.iti.regra.exception.RegraCaracterRepetidoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegraCaracterRepetidoImplTeste {

    private RegraCaracterRepetidoImpl regraCaracterRepetido = new RegraCaracterRepetidoImpl();

    @Test
    public void verificarSenhaSemCaracteresRepetidos() {
        assertAll(() -> regraCaracterRepetido.validarRegra("abcd"));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "abca",
            "abac",
            "aabc",
            "aaaa"
    })
    public void verificarSenhaComCaracteresRepetidos(String valor) {
        assertThrows(RegraCaracterRepetidoException.class, () -> regraCaracterRepetido.validarRegra(valor));
    }

}
