package br.com.java.gerenciador_estudos.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RegraNegocioException extends RuntimeException {

    public RegraNegocioException(String mensagem, Throwable error) {
        super(mensagem, error);
    }

    public RegraNegocioException(String mensagem) {
        super(mensagem);
    }
}
