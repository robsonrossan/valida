package br.com.desafio.iti.regra.impl;

import br.com.desafio.iti.regra.Regra;
import br.com.desafio.iti.regra.exception.RegraException;
import br.com.desafio.iti.regra.exception.RegraUmDigitoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RegraUmDigitoImpl implements Regra {

    @Override
    public void validarRegra(String senha) throws RegraException {

        log.info("Verifica se a senha tem ao menos 1 dígito");

        if (!senha.chars().anyMatch(Character::isDigit)) {
            throw new RegraUmDigitoException("Senha nao possui nenhum digito");
        }
    }
}
