package br.com.desafio.iti.regra.impl;

import br.com.desafio.iti.regra.Regra;
import br.com.desafio.iti.regra.exception.RegraEspacoEmBrancoException;
import br.com.desafio.iti.regra.exception.RegraException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RegraEspacoEmBrancoImpl implements Regra {

    @Override
    public void validarRegra(String senha) throws RegraException {

        log.info("Verifica se a senha tem espaço em branco");

        if (!senha.chars().noneMatch(Character::isWhitespace)) {
            throw new RegraEspacoEmBrancoException("Senha possui espaço em branco");
        }
    }

}
