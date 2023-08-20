package br.com.mundo.RHApi.dto.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosCadastroVendasSemanais(
        @NotNull
        Long idAtendente,
        BigDecimal vendasPrimeiraSemana,
        BigDecimal vendasSegundaSemana,
        BigDecimal vendasTerceiraSemana,
        BigDecimal vendasQuartaSemana,
        BigDecimal vendasQuintaSemana,
        BigDecimal vendasSextaSemana
) {
}
