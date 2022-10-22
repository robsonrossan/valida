package br.com.desafio.iti.regra.impl;

import br.com.desafio.iti.regra.Regra;
import br.com.desafio.iti.regra.exception.RegraCaracterRepetidoException;
import br.com.desafio.iti.regra.exception.RegraException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RegraCaracterRepetidoImpl implements Regra {

    @Override
    public void validarRegra(String senha) throws RegraException {

        log.info("Verifica se a senha tem caracteres repetidos");

        if (!contemCaracteresUnicos(senha)) {
            throw new RegraCaracterRepetidoException("Senha possui caracteres repetidos");
        }
    }

    private boolean contemCaracteresUnicos(String senha) {
        for (int i = 0; i < senha.length(); i++) {
            for (int j = i + 1; j < senha.length(); j++) {
                if (senha.charAt(i) == senha.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
