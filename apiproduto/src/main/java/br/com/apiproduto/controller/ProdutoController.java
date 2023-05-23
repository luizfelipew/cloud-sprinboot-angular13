package br.com.apiproduto.controller;

import br.com.apiproduto.entity.Produto;
import br.com.apiproduto.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos() {
        return ResponseEntity
                .ok(produtoService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody final Produto produto) {
        val novoProduto = produtoService.salvar(produto);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity
                .ok()
                .build();
    }
}
