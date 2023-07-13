package br.com.mundo.RHApi.modelos.calculadora;

import br.com.mundo.RHApi.modelos.atendente.Atendente;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CalculadoraGratificacao {

    private List<Atendente> listaAtendenteCalculadora = new ArrayList<>();

    public CalculadoraGratificacao(){}

    protected List<Atendente> calcularGratificacao(List<Atendente> lista, BigDecimal percentual1, BigDecimal percentual2, BigDecimal percentual3, BigDecimal percentual4) {
        this.listaAtendenteCalculadora = lista;
        this.listaAtendenteCalculadora.sort(Comparator.comparing(Atendente::getVendaPrimeiraSemana).reversed());
        this.listaAtendenteCalculadora.get(0).setGratificacaoPrimeiraSemana(this.listaAtendenteCalculadora.get(0).getVendaPrimeiraSemana().multiply(percentual1).setScale(2, RoundingMode.UP));
        this.listaAtendenteCalculadora.get(1).setGratificacaoPrimeiraSemana(this.listaAtendenteCalculadora.get(1).getVendaPrimeiraSemana().multiply(percentual2).setScale(2, RoundingMode.UP));
        this.listaAtendenteCalculadora.get(2).setGratificacaoPrimeiraSemana(this.listaAtendenteCalculadora.get(2).getVendaPrimeiraSemana().multiply(percentual2).setScale(2, RoundingMode.UP));

        this.listaAtendenteCalculadora.subList(3, this.listaAtendenteCalculadora.size()).forEach(atendente -> atendente.setGratificacaoPrimeiraSemana(atendente.getVendaPrimeiraSemana().multiply(percentual4).setScale(2, RoundingMode.UP)));

       //primeira Semana acima.

        this.listaAtendenteCalculadora = lista;
        this.listaAtendenteCalculadora.sort(Comparator.comparing(Atendente::getVendaSegundaSemana).reversed());
        this.listaAtendenteCalculadora.get(0).setGratificacaoSegundaSemana(this.listaAtendenteCalculadora.get(0).getVendaSegundaSemana().multiply(percentual1).setScale(2, RoundingMode.UP));
        this.listaAtendenteCalculadora.get(1).setGratificacaoSegundaSemana(this.listaAtendenteCalculadora.get(1).getVendaSegundaSemana().multiply(percentual2).setScale(2, RoundingMode.UP));
        this.listaAtendenteCalculadora.get(2).setGratificacaoSegundaSemana(this.listaAtendenteCalculadora.get(2).getVendaSegundaSemana().multiply(percentual2).setScale(2, RoundingMode.UP));

        this.listaAtendenteCalculadora.subList(3, this.listaAtendenteCalculadora.size()).forEach(atendente -> atendente.setGratificacaoSegundaSemana(atendente.getVendaSegundaSemana().multiply(percentual4).setScale(2, RoundingMode.UP)));

        //segunda Semana acima.

        this.listaAtendenteCalculadora = lista;
        this.listaAtendenteCalculadora.sort(Comparator.comparing(Atendente::getVendaTerceiraSemana).reversed());
        this.listaAtendenteCalculadora.get(0).setGratificacaoTerceiraSemana(this.listaAtendenteCalculadora.get(0).getVendaTerceiraSemana().multiply(percentual1).setScale(2, RoundingMode.UP));
        this.listaAtendenteCalculadora.get(1).setGratificacaoTerceiraSemana(this.listaAtendenteCalculadora.get(1).getVendaTerceiraSemana().multiply(percentual2).setScale(2, RoundingMode.UP));
        this.listaAtendenteCalculadora.get(2).setGratificacaoTerceiraSemana(this.listaAtendenteCalculadora.get(2).getVendaTerceiraSemana().multiply(percentual2).setScale(2, RoundingMode.UP));

        this.listaAtendenteCalculadora.subList(3, this.listaAtendenteCalculadora.size()).forEach(atendente -> atendente.setGratificacaoTerceiraSemana(atendente.getVendaTerceiraSemana().multiply(percentual4).setScale(2, RoundingMode.UP)));

        //terceira Semana acima.

        this.listaAtendenteCalculadora = lista;
        this.listaAtendenteCalculadora.sort(Comparator.comparing(Atendente::getVendaQuartaSemana).reversed());
        this.listaAtendenteCalculadora.get(0).setGratificacaoQuartaSemana(this.listaAtendenteCalculadora.get(0).getVendaQuartaSemana().multiply(percentual1).setScale(2, RoundingMode.UP));
        this.listaAtendenteCalculadora.get(1).setGratificacaoQuartaSemana(this.listaAtendenteCalculadora.get(1).getVendaQuartaSemana().multiply(percentual2).setScale(2, RoundingMode.UP));
        this.listaAtendenteCalculadora.get(2).setGratificacaoQuartaSemana(this.listaAtendenteCalculadora.get(2).getVendaQuartaSemana().multiply(percentual2).setScale(2, RoundingMode.UP));

        this.listaAtendenteCalculadora.subList(3, this.listaAtendenteCalculadora.size()).forEach(atendente -> atendente.setGratificacaoQuartaSemana(atendente.getVendaQuartaSemana().multiply(percentual4).setScale(2, RoundingMode.UP)));

        //quarta Semana acima.

        this.listaAtendenteCalculadora = lista;
        this.listaAtendenteCalculadora.sort(Comparator.comparing(Atendente::getVendaQuintaSemana).reversed());
        this.listaAtendenteCalculadora.get(0).setGratificacaoQuintaSemana(this.listaAtendenteCalculadora.get(0).getVendaQuintaSemana().multiply(percentual1).setScale(2, RoundingMode.UP));
        this.listaAtendenteCalculadora.get(1).setGratificacaoQuintaSemana(this.listaAtendenteCalculadora.get(1).getVendaQuintaSemana().multiply(percentual2).setScale(2, RoundingMode.UP));
        this.listaAtendenteCalculadora.get(2).setGratificacaoQuintaSemana(this.listaAtendenteCalculadora.get(2).getVendaQuintaSemana().multiply(percentual2).setScale(2, RoundingMode.UP));

        this.listaAtendenteCalculadora.subList(3, this.listaAtendenteCalculadora.size()).forEach(atendente -> atendente.setGratificacaoQuintaSemana(atendente.getVendaQuintaSemana().multiply(percentual4).setScale(2, RoundingMode.UP)));

        //quinta Semana acima.

        return this.listaAtendenteCalculadora;
    }

}
