package br.com.mundo.RHApi.dto.response;

import br.com.mundo.RHApi.model.Atendente;

public record DadosDetalhamentoAtendente(Long id, String nome, String loja) {
    public DadosDetalhamentoAtendente(Atendente atendente) {
        this(atendente.getId(), atendente.getNome(), atendente.getLoja());
    }
}
