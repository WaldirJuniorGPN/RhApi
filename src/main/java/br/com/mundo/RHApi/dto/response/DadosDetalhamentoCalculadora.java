package br.com.mundo.RHApi.dto.response;

import br.com.mundo.RHApi.model.Calculadora;

import java.util.Map;

public record DadosDetalhamentoCalculadora(
        Double percentualPrimeiroColocado,
        Double percentualSegundoColocado,
        Double percentualTerceiroColocado,
        Double percentualDemaisColocados
) {
    public DadosDetalhamentoCalculadora(Calculadora calculadora) {
        this(calculadora.getPercentualPrimeiroColocado(), calculadora.getPercentualSegundoColocado(), calculadora.getPercentualTerceiroColocado(),
                calculadora.getPercentualDemaisColocados());
    }
}
