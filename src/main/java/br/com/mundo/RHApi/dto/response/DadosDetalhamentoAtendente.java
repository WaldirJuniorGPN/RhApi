package br.com.mundo.RHApi.dto.response;

import br.com.mundo.RHApi.model.Atendente;
import br.com.mundo.RHApi.model.Loja;

public record DadosDetalhamentoAtendente(Long id, String nome, Loja loja) {

    public DadosDetalhamentoAtendente(Atendente atendente){
        this(atendente.getId(), atendente.getNome(), atendente.getLoja());
    }
}
