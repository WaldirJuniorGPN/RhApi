package br.com.mundo.RHApi.repository;

import br.com.mundo.RHApi.model.Atendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendenteRepository extends JpaRepository<Atendente, Long> {
}
