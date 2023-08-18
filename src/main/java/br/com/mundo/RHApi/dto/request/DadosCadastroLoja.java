package br.com.mundo.RHApi.dto.request;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroLoja(
        @NotBlank
        String nome
) {
}
