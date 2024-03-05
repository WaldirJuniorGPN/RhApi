package br.com.mundo.RHApi.dto.request;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAtendente(
        @NotBlank
        String nome,
        @NotBlank
        String loja
) {
}
