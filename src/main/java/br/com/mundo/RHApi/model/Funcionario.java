package br.com.mundo.RHApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "Funcionario")
@Table(name = "funcionarios")
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorColumn(name = "tipo-funcionario")
@Getter
@EqualsAndHashCode(of = "id")
public abstract class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal salario;

}
