package br.com.mundo.RHApi.dto.request;

import br.com.mundo.RHApi.model.Calculadora;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoLoja(
        @NotNull
        Long id,
        String nome,
        Calculadora calculadora
) {
}
