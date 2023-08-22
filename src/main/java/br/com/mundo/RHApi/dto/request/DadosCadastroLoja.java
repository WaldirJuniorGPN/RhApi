package br.com.mundo.RHApi.dto.request;

import br.com.mundo.RHApi.model.Calculadora;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroLoja(
        @NotBlank
        String nome,
        @NotNull
        Calculadora calculadora
) {
}
