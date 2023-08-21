package br.com.mundo.RHApi.dto.request;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroCalculadora(
        @NotNull
        Double percentualPrimeiroColocado,
        @NotNull
        Double percentualSegundoColocado,
        @NotNull
        Double percentualTerceiroColocado,
        @NotNull
        Double percentualDemaisColocados
) {
}
