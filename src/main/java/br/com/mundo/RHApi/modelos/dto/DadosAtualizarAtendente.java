package br.com.mundo.RHApi.modelos.dto;

import br.com.mundo.RHApi.modelos.Loja;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosAtualizarAtendente(
        @NotNull
        Long id,
        String nome,
        Loja loja,
        @DecimalMin(value = "0.00")
        @Digits(integer = 6, fraction = 2)
        BigDecimal salario,
        @DecimalMin(value = "0.00")
        @Digits(integer = 6, fraction = 2)
        BigDecimal vendasPrimeiraSemana,
        @DecimalMin(value = "0.00")
        @Digits(integer = 6, fraction = 2)
        BigDecimal vendasSegundaSemana,
        @DecimalMin(value = "0.00")
        @Digits(integer = 6, fraction = 2)
        BigDecimal vendasTerceiraSemana,
        @DecimalMin(value = "0.00")
        @Digits(integer = 6, fraction = 2)
        BigDecimal vendasQuartaSemana,
        @DecimalMin(value = "0.00")
        @Digits(integer = 6, fraction = 2)
        BigDecimal vendasQuintaSemana,
        @DecimalMin(value = "0.00")
        @Digits(integer = 6, fraction = 2)
        BigDecimal vendasSextaSemana
        ) {
}
