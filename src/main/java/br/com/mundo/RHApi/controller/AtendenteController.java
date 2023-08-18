package br.com.mundo.RHApi.controller;

import br.com.mundo.RHApi.dto.request.DadosCadastroAtedente;
import br.com.mundo.RHApi.dto.response.DadosDetalhamentoAtendente;
import br.com.mundo.RHApi.model.Atendente;
import br.com.mundo.RHApi.repository.AtendenteRepository;
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
@RequestMapping("atendentes")
public class AtendenteController {

    @Autowired
    private AtendenteRepository atendenteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAtedente dados, UriComponentsBuilder uriBuilder) {

        var atendente = new Atendente(dados);
        this.atendenteRepository.save(atendente);
        var uri =uriBuilder.path("/atendentes/{id}").buildAndExpand(atendente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoAtendente(atendente));
    }
}
