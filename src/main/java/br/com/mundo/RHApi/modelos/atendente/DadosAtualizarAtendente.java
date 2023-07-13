package br.com.mundo.RHApi.modelos.atendente;

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
        BigDecimal salario) {
}
