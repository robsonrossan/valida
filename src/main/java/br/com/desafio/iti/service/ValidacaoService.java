package br.com.desafio.iti.service;

import br.com.desafio.iti.dto.SenhaDTO;
import br.com.desafio.iti.dto.SenhaStatusDTO;

public interface ValidacaoService {

    SenhaStatusDTO validarSenha(SenhaDTO senhaDTO);
}
