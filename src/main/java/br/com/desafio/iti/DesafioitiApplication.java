package br.com.desafio.iti;

import br.com.desafio.iti.regra.Regra;
import br.com.desafio.iti.regra.impl.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DesafioitiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafioitiApplication.class, args);
    }

    @Bean
    public List<Regra> regrasValidacao() {
        return Arrays.asList(
                new RegraQtdeCaracteresImpl(),
                new RegraUmDigitoImpl(),
                new RegraLetraMinusculaImpl(),
                new RegraLetraMaiusculaImpl(),
                new RegraCaracterEspecialImpl(),
                new RegraCaracterRepetidoImpl(),
                new RegraEspacoEmBrancoImpl());
    }
}
