package br.com.java.gerenciador_estudos.repository;

import br.com.java.gerenciador_estudos.domain.entity.Estudos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudosRepository extends JpaRepository<Estudos, Long> {
}
