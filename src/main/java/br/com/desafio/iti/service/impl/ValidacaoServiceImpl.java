package br.com.desafio.iti.service.impl;

import br.com.desafio.iti.dto.SenhaDTO;
import br.com.desafio.iti.dto.SenhaStatusDTO;
import br.com.desafio.iti.regra.Regra;
import br.com.desafio.iti.regra.exception.RegraException;
import br.com.desafio.iti.service.ValidacaoService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ValidacaoServiceImpl implements ValidacaoService {

    private List<Regra> regrasValidacao;

    public ValidacaoServiceImpl(List<Regra> regrasValidacao) {
        this.regrasValidacao = regrasValidacao;
    }

    public SenhaStatusDTO validarSenha(SenhaDTO senhaDTO) {
        boolean senhaOk = true;
        String mensagemErro = null;

        for (Regra regra : regrasValidacao) {
            try {
                regra.validarRegra(senhaDTO.getSenha());
            } catch (RegraException re) {
                mensagemErro = re.getMessage();
                senhaOk = false;
                break;
            }
        }
        return SenhaStatusDTO.builder()
                .senhaValida(senhaOk)
                .mensagemErro(mensagemErro)
                .build();
    }
}
