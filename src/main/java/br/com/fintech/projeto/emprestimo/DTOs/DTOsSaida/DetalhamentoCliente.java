package br.com.fintech.projeto.emprestimo.DTOs.DTOsSaida;

import br.com.fintech.projeto.emprestimo.domain.Cliente.Cliente;

public record DetalhamentoCliente(String nome, String documento, String celular, Long score, boolean negativado, boolean ativo) {
    
    public DetalhamentoCliente(Cliente cliente){
        this(cliente.getNome(), cliente.getDocumento(), cliente.getCelular(), cliente.getScore(), cliente.isNegativado(), cliente.isAtivo());
    }

}
