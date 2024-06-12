package br.com.fintech.projeto.emprestimo.domain.Transação;

import br.com.fintech.projeto.emprestimo.domain.Cliente.Cliente;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Simulacoes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Simulacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double taxa;

    private Integer parcelas;

    private Double capitalFinal;

    private Double capitalInicial;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Simulacao(Double taxa, Integer parcelas, Double capitalInicial, Double capitalFinal, Cliente cliente){
        if(cliente != null){
            this.cliente = cliente;
        }
        this.capitalInicial = capitalInicial;
        this.capitalFinal = capitalFinal;
        this.parcelas = parcelas;
        this.taxa = taxa;


    }





}
