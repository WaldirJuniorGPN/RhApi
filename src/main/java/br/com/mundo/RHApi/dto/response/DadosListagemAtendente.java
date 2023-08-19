package br.com.mundo.RHApi.dto.response;

import br.com.mundo.RHApi.model.Atendente;
import br.com.mundo.RHApi.model.Loja;

public record DadosListagemAtendente(Long id, String nome, Long idLoja) {

    public DadosListagemAtendente(Atendente atendente) {
        this(atendente.getId(), atendente.getNome(), atendente.getLoja().getId());
    }
}
