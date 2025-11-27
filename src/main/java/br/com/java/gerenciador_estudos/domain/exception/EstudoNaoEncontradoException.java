package br.com.java.gerenciador_estudos.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EstudoNaoEncontradoException extends RuntimeException {

    public EstudoNaoEncontradoException (Long id) {
        super(String.format("O estudo de código %d, não esta cadastrado", id));
    }

    public EstudoNaoEncontradoException (String mensagem) {
        super(mensagem);
    }
}
