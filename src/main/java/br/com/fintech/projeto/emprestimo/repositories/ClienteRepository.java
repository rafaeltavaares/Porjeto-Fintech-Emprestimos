package br.com.fintech.projeto.emprestimo.repositories;

import br.com.fintech.projeto.emprestimo.domain.Cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {


    boolean existsByDocumento(String documento);

    Optional<Cliente> findByDocumento(String documento);



}
