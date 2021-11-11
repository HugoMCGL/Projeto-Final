package br.com.letscode.spring.projetofinal.cliente;

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
public class Cliente {
    @Id
    private Long telefone;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String endereco;

}
