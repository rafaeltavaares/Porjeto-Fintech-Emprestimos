package br.com.fintech.projeto.emprestimo.domain.Transação;

import br.com.fintech.projeto.emprestimo.domain.Cliente.Cliente;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transactions")
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transações {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private Long numeroParcelas;

    private Long valor;

    private double taxaJuros;

    private Double valorFinal;

}
