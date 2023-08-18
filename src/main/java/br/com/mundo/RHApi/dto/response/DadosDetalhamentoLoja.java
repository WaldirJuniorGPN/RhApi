package br.com.mundo.RHApi.dto.response;

import br.com.mundo.RHApi.model.Loja;

public record DadosDetalhamentoLoja(Long id, String nome) {

    public DadosDetalhamentoLoja(Loja loja){
        this(loja.getId(), loja.getNome());
    }
}
