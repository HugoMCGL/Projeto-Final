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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroPedido;

    @OneToOne
    @JoinColumn(name = "telefonecliente")
    private Cliente cliente;


    @ManyToOne
    @JoinColumn(name = "pizzaid")
    private Pizza pizza;

    @Column(nullable = false)
    private Double valor;
}
