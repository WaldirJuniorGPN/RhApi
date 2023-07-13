package br.com.mundo.RHApi.modelos.atendente;

import br.com.mundo.RHApi.modelos.Loja;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosCadastroAtendente(
        @NotBlank
        String nome,
        @NotNull
        Loja loja,
        @NotNull
        @DecimalMin(value = "0.00")
        @Digits(integer = 6, fraction = 2)
        BigDecimal salario) {
}
