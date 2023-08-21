package br.com.mundo.RHApi.dto.request;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCalculadora(
        @NotNull
        Long id,
        Double percentualPrimeiroColocado,
        Double percentualSegundoColocado,
        Double percentualTerceiroColocado,
        Double percentualDemaisColocados
) {
}
