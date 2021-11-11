package br.com.letscode.spring.projetofinal.pizza;

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
public class Pizza {
    @Id
    private Long id;

    @Column(nullable = false)
    private String sabor;

    @Column(nullable = false)
    private double preco;
}
