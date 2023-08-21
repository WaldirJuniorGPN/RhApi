package br.com.mundo.RHApi.dto.response;

import br.com.mundo.RHApi.model.Calculadora;

public record DadosListagemCalculadora(
        Long id,
        Double percentualPrimeiroColocado,
        Double percentualSegundoColocado,
        Double percentualTerceiroColocado,
        Double demaisColocados
) {
    public DadosListagemCalculadora(Calculadora calculadora) {
        this(calculadora.getId(), calculadora.getPercentualPrimeiroColocado(), calculadora.getPercentualSegundoColocado(), calculadora.getPercentualTerceiroColocado(),
                calculadora.getPercentualDemaisColocados());
    }
}
