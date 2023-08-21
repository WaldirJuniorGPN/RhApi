package br.com.mundo.RHApi.controller;

import br.com.mundo.RHApi.dto.request.DadosCadastroCalculadora;
import br.com.mundo.RHApi.dto.response.DadosDetalhamentoCalculadora;
import br.com.mundo.RHApi.model.Calculadora;
import br.com.mundo.RHApi.repository.CalculadoraRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("calculadora")
public class CalculadoraController {

    @Autowired
    private CalculadoraRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCalculadora dados, UriComponentsBuilder uriBuilder) {
        var calculadora = new Calculadora(dados);
        repository.save(calculadora);
        var uri = uriBuilder.path("/calculadora/{id}").buildAndExpand(calculadora.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCalculadora(calculadora));
    }
}
