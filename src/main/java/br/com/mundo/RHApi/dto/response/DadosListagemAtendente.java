package br.com.mundo.RHApi.dto.response;

import br.com.mundo.RHApi.model.Atendente;

public record DadosListagemAtendente(Long id, String nome, String loja) {
    public DadosListagemAtendente(Atendente atendente) {
        this(atendente.getId(), atendente.getNome(), atendente.getLoja());
    }
}
