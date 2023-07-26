package br.com.mundo.RHApi.modelos.dto;

import br.com.mundo.RHApi.modelos.Loja;
import br.com.mundo.RHApi.modelos.atendente.Atendente;

import java.math.BigDecimal;

public record DadosListagemAtendente(Long id, String nome, BigDecimal salario, Loja loja, BigDecimal vendas,
                                     BigDecimal gratificacao) {

    public DadosListagemAtendente(Atendente atendente) {
        this(atendente.getId(), atendente.getNome(), atendente.getSalario(),atendente.getLoja(), atendente.getVendaTotal(), atendente.getGratificacaoTotal());
    }
}
