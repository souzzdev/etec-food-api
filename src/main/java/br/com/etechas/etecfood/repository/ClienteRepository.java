package br.com.etechas.etecfood.repository;

import br.com.etechas.etecfood.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
