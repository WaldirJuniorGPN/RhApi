package br.com.mundo.RHApi.service;

import br.com.mundo.RHApi.repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;

public class CalculadoraQuartaSemanaService implements CalculadoraDeGratificacao {

    @Autowired
    private AtendenteRepository atendenteRepository;

    @Override
    public void calcularGratificacao() {
        var listaDeAtendente = atendenteRepository.findAll();
        listaDeAtendente.sort(Comparator.comparing(atendente -> atendente.getVendasSemanais().getVendasQuartaSemana()));
        Collections.reverse(listaDeAtendente);
        listaDeAtendente.get(0).setGratificacao(listaDeAtendente.get(0).getVendasSemanais().getVendasQuartaSemana().multiply(BigDecimal.valueOf(listaDeAtendente.get(0).getLoja().getCalculadora().getPercentualPrimeiroColocado())));
        listaDeAtendente.get(1).setGratificacao(listaDeAtendente.get(1).getVendasSemanais().getVendasQuartaSemana().multiply(BigDecimal.valueOf(listaDeAtendente.get(1).getLoja().getCalculadora().getPercentualSegundoColocado())));
        listaDeAtendente.get(2).setGratificacao(listaDeAtendente.get(2).getVendasSemanais().getVendasQuartaSemana().multiply(BigDecimal.valueOf(listaDeAtendente.get(2).getLoja().getCalculadora().getPercentualTerceiroColocado())));
        if (listaDeAtendente.size() > 3) {
            listaDeAtendente.subList(3, listaDeAtendente.size()).forEach(
                    atendente -> atendente.setGratificacao(atendente.getVendasSemanais().getVendasQuartaSemana().multiply(BigDecimal.valueOf(atendente.getLoja().getCalculadora().getPercentualDemaisColocados())))
            );
        }
    }
}