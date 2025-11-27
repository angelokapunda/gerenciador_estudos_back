package br.com.java.gerenciador_estudos.service;

import br.com.java.gerenciador_estudos.domain.entity.Estudos;
import br.com.java.gerenciador_estudos.domain.enums.Status;
import br.com.java.gerenciador_estudos.domain.exception.EstudoNaoEncontradoException;
import br.com.java.gerenciador_estudos.domain.exception.RegraNegocioException;
import br.com.java.gerenciador_estudos.repository.EstudosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudosService {

    @Autowired
    private EstudosRepository estudosRepository;

    public Estudos salvar (Estudos estudos) {
        return estudosRepository.save(estudos);
    }

    public List<Estudos> listar() {
        return estudosRepository.findAll();
    }

    public Estudos buscarPorId (long id) {
        return estudosRepository.findById(id).orElseThrow(
                () -> new EstudoNaoEncontradoException(id));
    }

    public List<Estudos> buscarPorStatus(String status) {
        try {
            Status convertString = Status.valueOf(status.toUpperCase());
            return estudosRepository.findByStatus(convertString);
        } catch (IllegalArgumentException e) {
            if (status.equalsIgnoreCase("pendente") || status.equalsIgnoreCase("em_andamento")
                    || status.equalsIgnoreCase("concluido")) {
                throw new EstudoNaoEncontradoException("Não tem nenhuma atividade com o Status consultado");
            }
            throw new RegraNegocioException("Status inválido. Verifique e tente novamente!");
        }

    }

//    public List<Estudos> buscarPorPrioridade(String prioridade, String status, String assunto) {
//        return estudosRepository.findByPrioridadeContainingAndStatusContainingAndAssuntoContaining(
//                prioridade, status, assunto);
//    }
}
