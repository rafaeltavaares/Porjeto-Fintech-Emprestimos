package br.com.fintech.projeto.emprestimo.services;

import br.com.fintech.projeto.emprestimo.DTOs.DTOsEntrada.DadosSalvarCliente;
import br.com.fintech.projeto.emprestimo.DTOs.DTOsSaida.DetalhamentoCliente;
import br.com.fintech.projeto.emprestimo.domain.Cliente.Cliente;
import br.com.fintech.projeto.emprestimo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServices {

    @Autowired
    private ClienteRepository repository;




    public void criar(DadosSalvarCliente dados){
        Cliente newCliente = new Cliente(dados);
        repository.save(newCliente);
    }

    public boolean AutorizarUsuario(String documento) {
        if (repository.existsByDocumento(documento)) {
            return true;
        }
        return false;

    }

    public Cliente acharCliente(String documento) throws RuntimeException{
        return repository.findByDocumento(documento).orElseThrow(()-> new RuntimeException("Não encontrado"));
    }





}
