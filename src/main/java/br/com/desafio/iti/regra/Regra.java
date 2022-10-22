package br.com.desafio.iti.regra;

import br.com.desafio.iti.regra.exception.RegraException;

public interface Regra {

    void validarRegra(String senha) throws RegraException;
}
