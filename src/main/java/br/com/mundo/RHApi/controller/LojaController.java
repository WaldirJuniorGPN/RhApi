package br.com.mundo.RHApi.controller;

import br.com.mundo.RHApi.dto.request.DadosCadastroLoja;
import br.com.mundo.RHApi.dto.response.DadosDetalhamentoLoja;
import br.com.mundo.RHApi.model.Loja;
import br.com.mundo.RHApi.repository.LojaRepository;
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
@RequestMapping("loja")
public class LojaController {

    @Autowired
    private LojaRepository lojaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroLoja dados, UriComponentsBuilder uriComponentsBuilder) {

        var loja = new Loja(dados);
        this.lojaRepository.save(loja);
        var uri = uriComponentsBuilder.path("/loja/{id}").buildAndExpand(loja.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoLoja(loja));
    }
}
