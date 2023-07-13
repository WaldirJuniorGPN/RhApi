package br.com.mundo.RHApi.modelos.atendente;

import br.com.mundo.RHApi.modelos.Loja;

import java.math.BigDecimal;

public record DadosListagemAtendente(Long id, String nome, BigDecimal salario, Loja loja, BigDecimal vendas,
                                     BigDecimal gratificacao) {

    public DadosListagemAtendente(Atendente atendente) {
        this(atendente.getId(), atendente.getNome(), atendente.getSalario(),atendente.getLoja(), atendente.getVendaTotal(), atendente.getGratificacaoTotal());
    }
}
