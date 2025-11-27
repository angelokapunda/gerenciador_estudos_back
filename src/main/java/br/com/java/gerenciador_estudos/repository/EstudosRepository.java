package br.com.java.gerenciador_estudos.repository;

import br.com.java.gerenciador_estudos.domain.entity.Estudos;
import br.com.java.gerenciador_estudos.domain.enums.Prioridade;
import br.com.java.gerenciador_estudos.domain.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudosRepository extends JpaRepository<Estudos, Long> {

    List<Estudos> findByStatus(Status status);
    List<Estudos> findByPrioridade(Prioridade prioridade);
    List<Estudos> findByTituloContainingIgnoreCase(String assunto);
}
