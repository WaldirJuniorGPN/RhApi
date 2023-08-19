package br.com.mundo.RHApi.dto.response;

import br.com.mundo.RHApi.model.Loja;

public record DadosListagemLoja(Long id, String nome) {
    public DadosListagemLoja(Loja loja){
        this(loja.getId(), loja.getNome());
    }
}
