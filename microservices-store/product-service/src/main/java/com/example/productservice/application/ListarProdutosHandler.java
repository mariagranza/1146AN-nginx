package com.example.productservice.application;

import com.example.productservice.domain.Produto;
import com.example.productservice.domain.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarProdutosHandler {

    private final ProdutoRepository produtoRepository;

    public List<Produto> handle() {
        return produtoRepository.findAll();
    }
}
