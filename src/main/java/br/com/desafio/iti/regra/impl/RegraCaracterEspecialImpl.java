package br.com.desafio.iti.regra.impl;

import br.com.desafio.iti.regra.Regra;
import br.com.desafio.iti.regra.exception.RegraCaracterEspecialException;
import br.com.desafio.iti.regra.exception.RegraException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RegraCaracterEspecialImpl implements Regra {

    private final String CARACTER_ESPECIAL_VALIDO = "!|@|#|$|%|^|&|\\*|(|)|\\-|\\+";

    @Override
    public void validarRegra(String senha) throws RegraException {

        log.info("Verifica se a senha tem caracteres especiais validos");

        final String regex = "^(?=.*[" + CARACTER_ESPECIAL_VALIDO + "]).*$";

        if (!senha.matches(regex)) {
            throw new RegraCaracterEspecialException("Senha precisa conter algum dos caracteres !|@|#|$|%|^|&|\\*|(|)|\\-|\\+");
        }
    }

}
