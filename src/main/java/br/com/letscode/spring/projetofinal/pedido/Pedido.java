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

    @ManyToOne
    @JoinColumn(name = "Cliente", foreignKey = @ForeignKey(name = "FK_CLIENTE_NAME", value = ConstraintMode.NO_CONSTRAINT))
    private Cliente cliente;


    @ManyToOne
    @JoinColumn(name = "Pizza", foreignKey = @ForeignKey(name = "FK_PIZZA_NAME", value = ConstraintMode.NO_CONSTRAINT))
    private Pizza pizza;

    @Column(nullable = false)
    private Double valor;
}
