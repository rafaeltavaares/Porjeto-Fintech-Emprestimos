package br.com.fintech.projeto.emprestimo.repositories;

import br.com.fintech.projeto.emprestimo.domain.Transação.Simulacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface SimulacaoRepository extends JpaRepository<Simulacao,Long> {
}
