package br.com.fintech.projeto.emprestimo.domain.Cliente;

import br.com.fintech.projeto.emprestimo.DTOs.DTOsEntrada.DadosSalvarCliente;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String documento;

    @Column(unique = true)
    private String celular;

    private Long score;

    private boolean negativado;

    private boolean Ativo;


    public Cliente(DadosSalvarCliente dados){
        this.nome = dados.nome();
        this.documento = dados.documento();
        this.celular = dados.celular();
        this.score = dados.score();
        this.negativado = dados.negativado();
        this.Ativo = true;
    }

}
