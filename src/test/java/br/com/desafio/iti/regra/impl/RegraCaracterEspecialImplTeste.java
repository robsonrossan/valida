package br.com.desafio.iti.regra.impl;

import br.com.desafio.iti.regra.exception.RegraCaracterEspecialException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegraCaracterEspecialImplTeste {

    private RegraCaracterEspecialImpl regraCaracterEspecial = new RegraCaracterEspecialImpl();

    @ParameterizedTest
    @ValueSource(strings = {
            "aa!aaa",
            "aa@aaa",
            "aa#aaa",
            "aa$aaa",
            "aa%aaa",
            "aa^aaa",
            "aa&aaa",
            "aa*aaa",
            "aa(aaa",
            "aa)aaa",
            "aa-aaa",
            "aa+aaa"
    })
    public void verificarSenhaComAoMenosUmCaracterEspecialPermitido(String valor) {
        assertAll(() -> regraCaracterEspecial.validarRegra(valor));
    }

    @Test
    public void verificarSenhaSemNenhumCaracterEspecial() {
        assertThrows(RegraCaracterEspecialException.class, () -> regraCaracterEspecial.validarRegra("aaaaaa"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"aa=aaa", "aa[aaa", "aa}aaa"})
    public void verificarSenhaComCaracterEspecialNaoPermitido(String valor) {
        assertThrows(RegraCaracterEspecialException.class, () -> regraCaracterEspecial.validarRegra(valor));
    }
}
