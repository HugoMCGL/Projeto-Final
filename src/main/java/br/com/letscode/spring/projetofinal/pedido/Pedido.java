package br.com.letscode.spring.projetofinal.pedido;


import br.com.letscode.spring.projetofinal.cliente.Cliente;
import br.com.letscode.spring.projetofinal.pizza.Pizza;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity

public class Pedido {
    @Id
    private Long numeroPedido;

    @OneToOne
    @JoinColumn(name = "telefone_cliente")
    private Cliente cliente;


    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

    @Column(nullable = false)
    private Double valor;
}
