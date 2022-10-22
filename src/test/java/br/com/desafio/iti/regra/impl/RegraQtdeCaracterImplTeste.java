package br.com.desafio.iti.regra.impl;

import br.com.desafio.iti.regra.exception.RegraQtdeCaracteresException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegraQtdeCaracterImplTeste {

    private RegraQtdeCaracteresImpl regraQtdeCaracteres = new RegraQtdeCaracteresImpl();

    @ParameterizedTest
    @ValueSource(strings = {
            "aaabbbccc",
            "aaabbbcccd"
    })
    public void verificarSenhaComAQtdeMinimaDeCaracters(String valor) {
        assertAll(() -> regraQtdeCaracteres.validarRegra(valor));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "aaabbbcc",
            ""
    })
    public void verificarSenhaComAQtdeInsuficienteDeCaracteres(String valor) {
        assertThrows(RegraQtdeCaracteresException.class, () -> regraQtdeCaracteres.validarRegra(valor));
    }
}
