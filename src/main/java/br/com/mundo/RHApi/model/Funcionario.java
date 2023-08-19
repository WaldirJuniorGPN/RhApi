package br.com.mundo.RHApi.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "Funcionario")
@Table(name = "funcionarios")
@NoArgsConstructor
@DiscriminatorColumn(name = "tipo_funcionario")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public abstract class Funcionario {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal salario;

}
