package br.com.apiproduto.service.impl;

import br.com.apiproduto.entity.Produto;
import br.com.apiproduto.repository.ProdutoRepository;
import br.com.apiproduto.service.ProdutoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void delete(Long id) {
        try {
            produtoRepository.deleteById(id);
        } catch (Exception ex) {
            throw new RuntimeException("ocorreu um erro ao excluir o produto");
        }
    }
}
