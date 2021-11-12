package br.com.letscode.spring.projetofinal.pizza;


import br.com.letscode.spring.projetofinal.cliente.Cliente;
import br.com.letscode.spring.projetofinal.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public Pizza salvar (Pizza pizza){
        return pizzaRepository.save(pizza);
    }

    public List<Pizza> listaPizza(){
        return pizzaRepository.findAll();
    }

    public Optional<Pizza> buscarPorId(Long id){
        return pizzaRepository.findById(id);
    }

    public void removerPorId(Long id){
        pizzaRepository.deleteById(id);
    }
}