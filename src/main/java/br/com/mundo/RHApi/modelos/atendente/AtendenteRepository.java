package br.com.mundo.RHApi.modelos.atendente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtendenteRepository extends JpaRepository<Atendente, Long> {
    Page<Atendente> findAllByAtivoTrue(Pageable paginacao);

    List<Atendente> findAllByAtivoTrue();
}
