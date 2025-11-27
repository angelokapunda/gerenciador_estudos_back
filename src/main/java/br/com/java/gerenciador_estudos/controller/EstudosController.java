package br.com.java.gerenciador_estudos.controller;

import br.com.java.gerenciador_estudos.domain.entity.Estudos;
import br.com.java.gerenciador_estudos.domain.enums.Status;
import br.com.java.gerenciador_estudos.service.EstudosService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estudos")
public class EstudosController {

    @Autowired
    private EstudosService estudosService;

    @PostMapping
    public ResponseEntity<Estudos> cadastrarEstudos(@RequestBody @Valid Estudos estudos) {
        var tarefa = estudosService.salvar(estudos);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
    }

    @GetMapping
    public ResponseEntity<List<Estudos>> listar() {
        return ResponseEntity.ok().body(estudosService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudos> buscarPorId (@PathVariable Long id) {
        return ResponseEntity.ok().body(estudosService.buscarPorId(id));
    }

    @GetMapping("/status")
    public ResponseEntity<List<Estudos>> buscaPorStatus (@RequestParam String status) {
        return ResponseEntity.ok(estudosService.buscarPorStatus(status));
    }

    @GetMapping("/prioridade")
    public ResponseEntity<List<Estudos>> buscarPorPrioridade (@RequestParam String prioridade) {
        return ResponseEntity.ok(estudosService.buscarPorPrioridade(prioridade));
    }

    @GetMapping("/titulo")
    public ResponseEntity<List<Estudos>> buscarPorTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(estudosService.buscarPorTitulo(titulo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudos> atualizar (@RequestBody Estudos estudos, @PathVariable Long id) {
        return ResponseEntity.ok().body(estudosService.atualizar(estudos, id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir (@PathVariable Long id) {
        estudosService.excluir(id);
    }
}
