package br.com.letscode.spring.projetofinal.pizza;

import br.com.letscode.spring.projetofinal.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
