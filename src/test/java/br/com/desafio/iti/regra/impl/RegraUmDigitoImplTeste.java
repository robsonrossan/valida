package br.com.desafio.iti.regra.impl;

import br.com.desafio.iti.regra.exception.RegraUmDigitoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegraUmDigitoImplTeste {

    private RegraUmDigitoImpl regraUmDigito = new RegraUmDigitoImpl();

    @ParameterizedTest
    @ValueSource(strings = {
            "Abca1",
            "Ab1Ac1"
    })
    public void verificarSenhaComAoMenosUmDigito(String valor) {
        assertAll(() -> regraUmDigito.validarRegra(valor));
    }

    @Test
    public void verificarSenhaSemNehhumDigito() {
        assertThrows(RegraUmDigitoException.class, () -> regraUmDigito.validarRegra("Abcd"));
    }

}
