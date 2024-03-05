package br.com.mundo.RHApi.dto.request;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAtendente(
        @NotNull
        Long id,
        String nome,
        String loja
) {
}
