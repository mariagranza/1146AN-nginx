package com.example.productservice.application;

import com.example.productservice.domain.Produto;
import com.example.productservice.domain.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuscarProdutoHandler {

    private final ProdutoRepository produtoRepository;

    public Optional<Produto> handle(Long id) {
        return produtoRepository.findById(id);
    }
}
