package br.com.desafio.iti.regra.impl;

import br.com.desafio.iti.regra.exception.RegraLetraMinusculaException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegraLetraMinusculaImplTeste {

    private RegraLetraMinusculaImpl regraLetraMinuscula = new RegraLetraMinusculaImpl();

    @ParameterizedTest
    @ValueSource(strings = {
            "Abca",
            "AbAc"
    })
    public void verificarSenhaComAoMenosUmaLetraMaiscula(String valor) {
        assertAll(() -> regraLetraMinuscula.validarRegra(valor));
    }

    @Test
    public void verificarSenhaSemNenhumaLetraMaiscula() {
        assertThrows(RegraLetraMinusculaException.class, () -> regraLetraMinuscula.validarRegra("ABCD"));
    }
}
