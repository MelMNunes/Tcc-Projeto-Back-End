package br.unisc.tcc_projeto.repositories;

import br.unisc.tcc_projeto.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
