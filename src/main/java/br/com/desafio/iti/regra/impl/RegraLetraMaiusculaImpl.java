package br.com.desafio.iti.regra.impl;

import br.com.desafio.iti.regra.Regra;
import br.com.desafio.iti.regra.exception.RegraException;
import br.com.desafio.iti.regra.exception.RegraLetraMaiusculaException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RegraLetraMaiusculaImpl implements Regra {

    @Override
    public void validarRegra(String senha) throws RegraException {

        log.info("Verifica se a senha tem pelo  menos uma letra maiúscula");

        if (!senha.chars().anyMatch(Character::isUpperCase)) {
            throw new RegraLetraMaiusculaException("Senha nao possui nenhuma letra maiuscula");
        }
    }

}
