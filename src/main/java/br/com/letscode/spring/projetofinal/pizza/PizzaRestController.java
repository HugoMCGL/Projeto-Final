package br.com.letscode.spring.projetofinal.pizza;

import br.com.letscode.spring.projetofinal.cliente.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaRestController {

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pizza salvar(@RequestBody Pizza pizza){
        return pizzaService.salvar(pizza);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pizza> listaPizza(){
        return pizzaService.listaPizza();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pizza buscarPizzaPorId(@PathVariable("id") Long id){
        return pizzaService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizza nao encontrada."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPizza(@PathVariable("id") Long id){
        pizzaService.buscarPorId(id)
                .map(cliente -> {
                    pizzaService.removerPorId(cliente.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizza nao encontrada."));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPizza(@PathVariable("id") Long id, @RequestBody Pizza pizza){
        pizzaService.buscarPorId(id)
                .map(pizzaBase -> {
                    modelMapper.map(pizza, pizzaBase);
                    pizzaService.salvar(pizzaBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado."));
    }
}
