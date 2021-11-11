package br.com.letscode.spring.projetofinal.pedido;


import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity

public class Pedido {
    @Id
    private Long numeroPedido;

    @Column(nullable = false)
    private String cliente;

    @Column(nullable = false)
    private String saborPizza;

    @Column(nullable = false)
    private Double valor;
}
