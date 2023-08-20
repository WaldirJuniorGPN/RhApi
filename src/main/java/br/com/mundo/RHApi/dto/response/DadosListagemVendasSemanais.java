package br.com.mundo.RHApi.dto.response;

import br.com.mundo.RHApi.model.VendasSemanais;

import java.math.BigDecimal;

public record DadosListagemVendasSemanais(
        Long id,
        BigDecimal vendasPrimeiraSemana,
        BigDecimal vendasSegundaSemana,
        BigDecimal vendasTerceiraSemana,
        BigDecimal vendasQuartaSemana,
        BigDecimal vendasQuintaSemana,
        BigDecimal vendasSextaSemana,
        Long idAtendente
) {
    public DadosListagemVendasSemanais(VendasSemanais vendas) {
        this(vendas.getId(), vendas.getVendasPrimeiraSemana(), vendas.getVendasSegundaSemana(),vendas.getVendasTerceiraSemana(),
                vendas.getVendasQuartaSemana(), vendas.getVendasQuintaSemana(),vendas.getVendasSextaSemana(),vendas.getAtendente().getId());
    }
}
