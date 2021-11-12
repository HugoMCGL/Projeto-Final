package br.com.letscode.spring.projetofinal.pedido;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping("pedidos")
@RestController
public class PedidoRestController {
    private final PedidoRepository pedidoRepository;

    public PedidoRestController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping
    public List<Pedido> pedidos() {
        return this.pedidoRepository.findAll();
    }

    @PostMapping
    public Pedido salvar(@RequestBody Pedido pedido) {
        return this.pedidoRepository.save(pedido);
    }

    @GetMapping("/{id}")
    public Pedido buscarPedidoPorId(@PathVariable("id") Long id) {
        return this.pedidoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado."));
    }

    @DeleteMapping("/{id}")
    public void removerCliente(@PathVariable("id") Long id) {
        this.pedidoRepository.findById(id)
                .map(pedido -> {
                    this.pedidoRepository.deleteById(pedido.getNumeroPedido());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado."));
    }

}
