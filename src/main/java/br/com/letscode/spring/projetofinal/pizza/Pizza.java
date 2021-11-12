package br.com.letscode.spring.projetofinal.pizza;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sabor", nullable = false)
    private String sabor;

    @Column(name = "preco", nullable = false)
    private String preco;
}