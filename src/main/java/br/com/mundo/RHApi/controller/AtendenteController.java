package br.com.mundo.RHApi.controller;

import br.com.mundo.RHApi.dto.request.DadosAtualizacaoAtendente;
import br.com.mundo.RHApi.dto.request.DadosCadastroAtendente;
import br.com.mundo.RHApi.dto.response.DadosDetalhamentoAtendente;
import br.com.mundo.RHApi.dto.response.DadosListagemAtendente;
import br.com.mundo.RHApi.model.Atendente;
import br.com.mundo.RHApi.repository.AtendenteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("atendentes")
public class AtendenteController {

    @Autowired
    private AtendenteRepository atendenteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoAtendente> cadastrar(@Valid @RequestBody DadosCadastroAtendente dados, UriComponentsBuilder uriComponentsBuilder) {
        var atendente = new Atendente(dados);
        var uri = uriComponentsBuilder.path("atendentes/{id}").buildAndExpand(atendente.getId()).toUri();
        this.atendenteRepository.save(atendente);
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAtendente(atendente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAtendente>> listar(Pageable paginacao) {
        var page = this.atendenteRepository.findAll(paginacao).map(DadosListagemAtendente::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoAtendente> buscarPorId(@PathVariable Long id) {
        var atendente = this.atendenteRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoAtendente(atendente));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoAtendente> atualizar(@Valid @RequestBody DadosAtualizacaoAtendente dados) {
        var atendente = this.atendenteRepository.getReferenceById(dados.id());
        atendente.atualizar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoAtendente(atendente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        this.atendenteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
