package br.com.fintech.projeto.emprestimo.DTOs.DTOsEntrada;

public record DadosEmprestimo(String documento, Integer numeroParcela, Double valor, Double TaxaJuros) {
}
