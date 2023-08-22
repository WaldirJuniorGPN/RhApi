package br.com.mundo.RHApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculadoraService {

    @Autowired
    private List<CalculadoraDeGratificacao> calculadora;

    public void calcular() {
        calculadora.forEach(calculadoraDeGratificacao -> calculadoraDeGratificacao.calcularGratificacao());
    }

}