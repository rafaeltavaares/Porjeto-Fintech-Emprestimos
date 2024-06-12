package br.com.fintech.projeto.emprestimo.services;

import br.com.fintech.projeto.emprestimo.DTOs.DTOsEntrada.DadosEmprestimo;
import br.com.fintech.projeto.emprestimo.DTOs.DTOsSaida.DadosSimulacao;
import br.com.fintech.projeto.emprestimo.domain.Cliente.Cliente;
import br.com.fintech.projeto.emprestimo.domain.Transação.Simulacao;
import br.com.fintech.projeto.emprestimo.repositories.SimulacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class SimulacaoService {

    @Autowired
    private SimulacaoRepository repository;

    @Autowired
    private ClienteServices clienteServices;

    @Autowired
    @Qualifier("taxas")
    private HashMap<Integer, Double> taxas_juros;

    private double taxaScore(Long score){
        if(score < 500 && score > 0){return 0.002;}
        if (score >= 500 && score < 1000){return 0.013;}
        return 0;
    }

    private double CalcularCapitalFinal(double taxaJuros, double valor, Integer numeroParcelas){ return valor * Math.pow((1+ taxaJuros), numeroParcelas); }

    public DadosSimulacao simulacao(DadosEmprestimo dados){
        verificarEntrada(dados.numeroParcela(), dados.TaxaJuros());

        if(clienteServices.AutorizarUsuario(dados.documento())){

            Cliente cliente = clienteServices.acharCliente(dados.documento());

            double novaTaxaJuros = dados.TaxaJuros() + this.taxaScore(cliente.getScore());

            var capitalFinal = CalcularCapitalFinal(novaTaxaJuros, dados.valor(), dados.numeroParcela());

            Simulacao simulacao = new Simulacao(dados.TaxaJuros(),dados.numeroParcela(), dados.valor(), capitalFinal, cliente);
            repository.save(simulacao);

            return new DadosSimulacao(dados.documento(), cliente.getScore(), dados.numeroParcela(), dados.TaxaJuros(), dados.valor(), capitalFinal, cliente);
        }

        var capitalFinal = CalcularCapitalFinal(dados.TaxaJuros(), dados.valor(), dados.numeroParcela());

        Simulacao simulacao = new Simulacao(dados.TaxaJuros(),dados.numeroParcela(), dados.valor(), capitalFinal, null);

        repository.save(simulacao);

        return new DadosSimulacao(dados.documento(), 0L, dados.numeroParcela(), dados.TaxaJuros(), dados.valor(), capitalFinal, null);
    }


    private void verificarEntrada(Integer numeroParcela, Double TaxaJuros){
        if(!taxas_juros.containsKey(numeroParcela)){
            throw new RuntimeException("Numero de parcelas inválidas");
        }
        if(!taxas_juros.containsValue(TaxaJuros)){
            throw new RuntimeException("Taxa de juros inválida");
        }
    }






}
