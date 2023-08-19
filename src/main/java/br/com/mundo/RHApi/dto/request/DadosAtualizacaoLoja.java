package br.com.mundo.RHApi.dto.request;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoLoja(
        @NotNull
        Long id,
        String nome
) {
}
