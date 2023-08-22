package br.com.mundo.RHApi.dto.response;

import br.com.mundo.RHApi.model.Calculadora;
import br.com.mundo.RHApi.model.Loja;

public record DadosDetalhamentoLoja(Long id, String nome, Calculadora calculadora) {

    public DadosDetalhamentoLoja(Loja loja) {
        this(loja.getId(), loja.getNome(), loja.getCalculadora());
    }
}
