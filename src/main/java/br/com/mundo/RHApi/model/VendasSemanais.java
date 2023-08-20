package br.com.mundo.RHApi.model;

import br.com.mundo.RHApi.dto.request.DadosAtualizacaoVendasSemanais;
import br.com.mundo.RHApi.dto.request.DadosCadastroVendasSemanais;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "VendasSemanais")
@Table(name = "vendas_semanais")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class VendasSemanais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal vendasPrimeiraSemana;
    private BigDecimal vendasSegundaSemana;
    private BigDecimal vendasTerceiraSemana;
    private BigDecimal vendasQuartaSemana;
    private BigDecimal vendasQuintaSemana;
    private BigDecimal vendasSextaSemana;

    @OneToOne(mappedBy = "vendasSemanais", fetch = FetchType.LAZY)
    private Atendente atendente;

    public VendasSemanais(DadosCadastroVendasSemanais dados) {
        this.vendasPrimeiraSemana = dados.vendasPrimeiraSemana();
        this.vendasSegundaSemana = dados.vendasSegundaSemana();
        this.vendasTerceiraSemana = dados.vendasTerceiraSemana();
        this.vendasQuartaSemana = dados.vendasQuartaSemana();
        this.vendasQuintaSemana = dados.vendasQuintaSemana();
        this.vendasSextaSemana = dados.vendasSextaSemana();
    }

    public void atualizacaoVendas(DadosAtualizacaoVendasSemanais dados) {
        if (dados.vendasPrimeiraSemana() != null) {
            this.vendasPrimeiraSemana = dados.vendasPrimeiraSemana();
        }
        if (dados.vendasSegundaSemana() != null) {
            this.vendasSegundaSemana = dados.vendasSegundaSemana();
        }
        if (dados.vendasTerceiraSemana() != null) {
            this.vendasTerceiraSemana = dados.vendasTerceiraSemana();
        }
        if (dados.vendasQuartaSemana() != null) {
            this.vendasQuartaSemana = dados.vendasQuartaSemana();
        }
        if (dados.vendasQuintaSemana() != null) {
            this.vendasQuintaSemana = dados.vendasQuintaSemana();
        }
        if (dados.vendasSextaSemana() != null) {
            this.vendasSextaSemana = dados.vendasSextaSemana();
        }
    }

}
