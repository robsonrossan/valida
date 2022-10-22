package br.com.desafio.iti.regra.impl;

import br.com.desafio.iti.regra.Regra;
import br.com.desafio.iti.regra.exception.RegraException;
import br.com.desafio.iti.regra.exception.RegraQtdeCaracteresException;
import org.springframework.stereotype.Component;

@Component
public class RegraQtdeCaracteresImpl implements Regra {

    @Override
    public void validarRegra(String senha) throws RegraException {
        if (senha.length() < 9) {
            throw new RegraQtdeCaracteresException("Senha precisa ter 9 caracteres no minimo");
        }
    }
}
