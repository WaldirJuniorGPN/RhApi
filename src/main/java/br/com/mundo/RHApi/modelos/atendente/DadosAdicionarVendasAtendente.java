package br.com.mundo.RHApi.modelos.atendente;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosAdicionarVendasAtendente(
        @NotNull
        Long id,
        @DecimalMin("0.00")
        @Digits(integer = 6, fraction = 2)
        BigDecimal vendas) {
}
