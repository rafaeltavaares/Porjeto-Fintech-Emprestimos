package br.com.fintech.projeto.emprestimo.DTOs.DTOsSaida;

import br.com.fintech.projeto.emprestimo.DTOs.DTOsEntrada.DadosEmprestimo;
import br.com.fintech.projeto.emprestimo.domain.Cliente.Cliente;

public record DadosSimulacao(String documento, Long score, int parcelas, Double taxa, Double valorInicial, Double valorFinal, Cliente cliente) {





}
