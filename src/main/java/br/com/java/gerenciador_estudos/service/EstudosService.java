package br.com.java.gerenciador_estudos.service;

import br.com.java.gerenciador_estudos.domain.entity.Estudos;
import br.com.java.gerenciador_estudos.domain.exception.EstudoNaoEncontradoException;
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
}
