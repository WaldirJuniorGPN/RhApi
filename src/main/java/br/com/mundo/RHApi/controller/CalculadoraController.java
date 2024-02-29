package br.com.mundo.RHApi.controller;

import br.com.mundo.RHApi.dto.request.DadosAtualizacaoCalculadora;
import br.com.mundo.RHApi.dto.request.DadosCadastroCalculadora;
import br.com.mundo.RHApi.dto.response.DadosDetalhamentoCalculadora;
import br.com.mundo.RHApi.dto.response.DadosListagemCalculadora;
import br.com.mundo.RHApi.model.Calculadora;
import br.com.mundo.RHApi.repository.CalculadoraRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("calculadora")
public class CalculadoraController {

    @Autowired
    private CalculadoraRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoCalculadora> cadastrar(@RequestBody @Valid DadosCadastroCalculadora dados, UriComponentsBuilder uriBuilder) {
        var calculadora = new Calculadora(dados);
        repository.save(calculadora);
        var uri = uriBuilder.path("/calculadora/{id}").buildAndExpand(calculadora.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCalculadora(calculadora));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCalculadora>> listar(Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemCalculadora::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoCalculadora> atualizar(@RequestBody @Valid DadosAtualizacaoCalculadora dados) {
        var atendente = repository.getReferenceById(dados.id());
        atendente.atualizarPercentual(dados);
        return ResponseEntity.ok(new DadosDetalhamentoCalculadora(atendente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
