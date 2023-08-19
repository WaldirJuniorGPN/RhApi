package br.com.mundo.RHApi.dto.request;

import br.com.mundo.RHApi.model.Loja;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosAtualizacaoAtendente(
        @NotNull
        Long id,
        String nome,
        BigDecimal salario,
        Loja loja
) {
}
