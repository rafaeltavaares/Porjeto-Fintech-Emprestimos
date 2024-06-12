package br.com.fintech.projeto.emprestimo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class EmprestimoConfig {

    @Bean(name = "taxas")
    public HashMap<Integer, Double> taxasJuros(){
        HashMap<Integer, Double> taxas_basicas = new HashMap<>();

        taxas_basicas.put(6, 0.04);
        taxas_basicas.put(12, 0.045);
        taxas_basicas.put(18, 0.05);
        taxas_basicas.put(24, 0.053);
        taxas_basicas.put(36, 0.055);

        return taxas_basicas;
    }

}
