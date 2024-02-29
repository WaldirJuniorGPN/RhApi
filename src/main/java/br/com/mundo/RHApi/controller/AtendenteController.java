package br.com.mundo.RHApi.controller;

import br.com.mundo.RHApi.dto.request.DadosAtualizacaoAtendente;
import br.com.mundo.RHApi.dto.request.DadosCadastroAtedente;
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
    public ResponseEntity<DadosDetalhamentoAtendente> cadastrar(@RequestBody @Valid DadosCadastroAtedente dados, UriComponentsBuilder uriBuilder) {

        var atendente = new Atendente(dados);
        this.atendenteRepository.save(atendente);
        var uri = uriBuilder.path("/atendentes/{id}").buildAndExpand(atendente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoAtendente(atendente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAtendente>> listar(Pageable paginacao) {
        var page = atendenteRepository.findAll(paginacao).map(DadosListagemAtendente::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoAtendente> atualizar(@RequestBody @Valid DadosAtualizacaoAtendente dados) {

        var atendente = atendenteRepository.getReferenceById(dados.id());
        atendente.atualizarAtendente(dados);
        return ResponseEntity.ok(new DadosDetalhamentoAtendente(atendente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        atendenteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
