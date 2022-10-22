package br.com.desafio.iti.dto;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SenhaDTO {

	@NotEmpty(message = "Campo Senha é Obrigatório")
    private String senha;

}