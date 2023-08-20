package br.com.mundo.RHApi.dto.response;

import br.com.mundo.RHApi.model.VendasSemanais;

import java.math.BigDecimal;

public record DadosDetalhamentoVendasSemanais(Long id, BigDecimal vendasPrimeiraSemana, BigDecimal vendasSegundaSemana,
                                              BigDecimal vendasTerceiraSemana,
                                              BigDecimal vendasQuartaSemana,
                                              BigDecimal vendasQuintaSemana,
                                              BigDecimal vendasSextaSemana) {
    public DadosDetalhamentoVendasSemanais(VendasSemanais vendasSemanais) {
        this(vendasSemanais.getId(), vendasSemanais.getVendasPrimeiraSemana(), vendasSemanais.getVendasSegundaSemana(), vendasSemanais.getVendasTerceiraSemana(),
                vendasSemanais.getVendasQuartaSemana(), vendasSemanais.getVendasQuintaSemana(), vendasSemanais.getVendasSextaSemana());
    }
}
