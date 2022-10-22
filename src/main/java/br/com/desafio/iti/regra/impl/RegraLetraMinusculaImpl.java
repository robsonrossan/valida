package br.com.desafio.iti.regra.impl;

import br.com.desafio.iti.regra.Regra;
import br.com.desafio.iti.regra.exception.RegraException;
import br.com.desafio.iti.regra.exception.RegraLetraMinusculaException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RegraLetraMinusculaImpl implements Regra {

    @Override
    public void validarRegra(String senha) throws RegraException {

        log.info("Verifica se a senha tem pelo menos uma letra minúscula");

        if (!senha.chars().anyMatch(Character::isLowerCase)) {
            throw new RegraLetraMinusculaException("Senha nao possui nenhuma letra minuscula");
        }
    }


}
