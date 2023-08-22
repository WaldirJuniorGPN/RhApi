package br.com.mundo.RHApi.dto.request;

import br.com.mundo.RHApi.model.Loja;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCalculadora(
        @NotNull
        Long id,
        Double percentualPrimeiroColocado,
        Double percentualSegundoColocado,
        Double percentualTerceiroColocado,
        Double percentualDemaisColocados,
        Loja loja
) {
}
