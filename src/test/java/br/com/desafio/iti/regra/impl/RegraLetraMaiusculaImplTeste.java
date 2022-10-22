package br.com.desafio.iti.regra.impl;

import br.com.desafio.iti.regra.exception.RegraLetraMaiusculaException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegraLetraMaiusculaImplTeste {

    private RegraLetraMaiusculaImpl regraLetraMaiuscula = new RegraLetraMaiusculaImpl();

    @ParameterizedTest
    @ValueSource(strings = {
            "Abca",
            "AbAc"
    })
    public void verificarSenhaComAoMenosUmaLetraMaiscula(String valor) {
        assertAll(() -> regraLetraMaiuscula.validarRegra(valor));
    }

    @Test
    public void verificarSenhaSemNenhumaLetraMaiscula() {
        assertThrows(RegraLetraMaiusculaException.class, () -> regraLetraMaiuscula.validarRegra("abcd"));
    }
}
