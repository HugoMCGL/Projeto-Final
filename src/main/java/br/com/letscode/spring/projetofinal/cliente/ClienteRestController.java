package br.com.letscode.spring.projetofinal.cliente;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("clientes")
@RestController
public class ClienteRestController {
    private final ClienteRepository clienteRepository;

    public ClienteRestController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Cliente> getClientes() {
        return this.clienteRepository.findAll();
    }

    @GetMapping("/{telefone}")
    public Cliente getByTelefone(@PathVariable Long telefone) {
        return this.clienteRepository.getById(telefone);
    }

    @PostMapping
    public void cadastrar(@RequestBody Cliente cliente) {
        this.clienteRepository.save(cliente);
    }

    @DeleteMapping("/{telefone}")
    public void deletar(@PathVariable Long telefone) {
        this.clienteRepository.deleteById(telefone);
    }
}
