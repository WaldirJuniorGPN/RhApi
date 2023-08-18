package br.com.mundo.RHApi.dto.request;

import br.com.mundo.RHApi.model.Loja;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosCadastroAtedente(
        @NotBlank
        String nome,
        BigDecimal salario,
        @NotNull
        Loja loja
) {
}
