package br.com.mundo.RHApi.model;

import br.com.mundo.RHApi.dto.request.DadosCadastroCalculadora;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Calculadora")
@Table(name = "calculadoras")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Calculadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double percentualPrimeiroColocado;
    private Double percentualSegundoColocado;
    private Double percentualTerceiroColocado;
    private Double percentualDemaisColocados;

    public Calculadora(DadosCadastroCalculadora dados) {
        this.percentualPrimeiroColocado = dados.percentualPrimeiroColocado();
        this.percentualSegundoColocado = dados.percentualSegundoColocado();
        this.percentualTerceiroColocado = dados.percentualTerceiroColocado();
        this.percentualDemaisColocados = dados.percentualDemaisColocados();
    }
}
