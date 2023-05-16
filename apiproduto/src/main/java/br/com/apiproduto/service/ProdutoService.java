package br.com.apiproduto.service;

import br.com.apiproduto.entity.Produto;

import java.util.List;

public interface ProdutoService {
    List<Produto> buscarTodos();
    Produto salvar(Produto produto);
    void delete(Long id);
}
