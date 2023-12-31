package br.com.mundo.RHApi.modelos.calculadora;

import br.com.mundo.RHApi.modelos.atendente.Atendente;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CalculadoraGratificacao {

    public CalculadoraGratificacao(){}

    protected void calcularGratificacao(List<Atendente> lista, BigDecimal percentual1, BigDecimal percentual2, BigDecimal percentual3, BigDecimal percentual4) {
        lista.sort(Comparator.comparing(Atendente::getVendaPrimeiraSemana).reversed());
        lista.get(0).setGratificacaoPrimeiraSemana(lista.get(0).getVendaPrimeiraSemana().multiply(percentual1).setScale(2, RoundingMode.UP));
        lista.get(1).setGratificacaoPrimeiraSemana(lista.get(1).getVendaPrimeiraSemana().multiply(percentual2).setScale(2, RoundingMode.UP));
        lista.get(2).setGratificacaoPrimeiraSemana(lista.get(2).getVendaPrimeiraSemana().multiply(percentual2).setScale(2, RoundingMode.UP));

        lista.subList(3, lista.size()).forEach(atendente -> atendente.setGratificacaoPrimeiraSemana(atendente.getVendaPrimeiraSemana().multiply(percentual4).setScale(2, RoundingMode.UP)));

       //primeira Semana acima.

        lista.sort(Comparator.comparing(Atendente::getVendaSegundaSemana).reversed());
        lista.get(0).setGratificacaoSegundaSemana(lista.get(0).getVendaSegundaSemana().multiply(percentual1).setScale(2, RoundingMode.UP));
        lista.get(1).setGratificacaoSegundaSemana(lista.get(1).getVendaSegundaSemana().multiply(percentual2).setScale(2, RoundingMode.UP));
        lista.get(2).setGratificacaoSegundaSemana(lista.get(2).getVendaSegundaSemana().multiply(percentual2).setScale(2, RoundingMode.UP));

        lista.subList(3, lista.size()).forEach(atendente -> atendente.setGratificacaoSegundaSemana(atendente.getVendaSegundaSemana().multiply(percentual4).setScale(2, RoundingMode.UP)));

        //segunda Semana acima.

        lista.sort(Comparator.comparing(Atendente::getVendaTerceiraSemana).reversed());
        lista.get(0).setGratificacaoTerceiraSemana(lista.get(0).getVendaTerceiraSemana().multiply(percentual1).setScale(2, RoundingMode.UP));
        lista.get(1).setGratificacaoTerceiraSemana(lista.get(1).getVendaTerceiraSemana().multiply(percentual2).setScale(2, RoundingMode.UP));
        lista.get(2).setGratificacaoTerceiraSemana(lista.get(2).getVendaTerceiraSemana().multiply(percentual2).setScale(2, RoundingMode.UP));

        lista.subList(3, lista.size()).forEach(atendente -> atendente.setGratificacaoTerceiraSemana(atendente.getVendaTerceiraSemana().multiply(percentual4).setScale(2, RoundingMode.UP)));

        //terceira Semana acima.

        lista.sort(Comparator.comparing(Atendente::getVendaQuartaSemana).reversed());
        lista.get(0).setGratificacaoQuartaSemana(lista.get(0).getVendaQuartaSemana().multiply(percentual1).setScale(2, RoundingMode.UP));
        lista.get(1).setGratificacaoQuartaSemana(lista.get(1).getVendaQuartaSemana().multiply(percentual2).setScale(2, RoundingMode.UP));
        lista.get(2).setGratificacaoQuartaSemana(lista.get(2).getVendaQuartaSemana().multiply(percentual2).setScale(2, RoundingMode.UP));

        lista.subList(3, lista.size()).forEach(atendente -> atendente.setGratificacaoQuartaSemana(atendente.getVendaQuartaSemana().multiply(percentual4).setScale(2, RoundingMode.UP)));

        //quarta Semana acima.

        lista.sort(Comparator.comparing(Atendente::getVendaQuintaSemana).reversed());
        lista.get(0).setGratificacaoQuintaSemana(lista.get(0).getVendaQuintaSemana().multiply(percentual1).setScale(2, RoundingMode.UP));
        lista.get(1).setGratificacaoQuintaSemana(lista.get(1).getVendaQuintaSemana().multiply(percentual2).setScale(2, RoundingMode.UP));
        lista.get(2).setGratificacaoQuintaSemana(lista.get(2).getVendaQuintaSemana().multiply(percentual2).setScale(2, RoundingMode.UP));

        lista.subList(3, lista.size()).forEach(atendente -> atendente.setGratificacaoQuintaSemana(atendente.getVendaQuintaSemana().multiply(percentual4).setScale(2, RoundingMode.UP)));

        //quinta Semana acima.

        lista.sort(Comparator.comparing(Atendente::getVendaSextaSemana).reversed());
        lista.get(0).setGratificacaoSextaSemana(lista.get(0).getVendaSextaSemana().multiply(percentual1).setScale(2, RoundingMode.UP));
        lista.get(1).setGratificacaoSextaSemana(lista.get(1).getVendaSextaSemana().multiply(percentual2).setScale(2, RoundingMode.UP));
        lista.get(2).setGratificacaoSextaSemana(lista.get(2).getVendaSextaSemana().multiply(percentual2).setScale(2, RoundingMode.UP));

        lista.subList(3, lista.size()).forEach(atendente -> atendente.setGratificacaoSextaSemana(atendente.getVendaSextaSemana().multiply(percentual4).setScale(2, RoundingMode.UP)));

        //sexta Semana acima.

        lista.forEach(atendente -> {
            atendente.setGratificacaoTotal(atendente.getGratificacaoPrimeiraSemana()
                    .add(atendente.getGratificacaoSegundaSemana()
                            .add(atendente.getGratificacaoTerceiraSemana()
                                    .add(atendente.getGratificacaoQuartaSemana()
                                            .add(atendente.getGratificacaoQuintaSemana()
                                                    .add(atendente.getGratificacaoSextaSemana()))))));

        });

    }

}
