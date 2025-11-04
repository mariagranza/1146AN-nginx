package com.example.productservice.infrastructure;

import com.example.productservice.domain.Produto;
import com.example.productservice.domain.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProdutoRepositoryAdapter implements ProdutoRepository {

    private final JpaProdutoRepository jpaProdutoRepository;

    @Override
    public Produto save(Produto produto) {
        return jpaProdutoRepository.save(produto);
    }

    @Override
    public Optional<Produto> findById(Long id) {
        return jpaProdutoRepository.findById(id);
    }

    @Override
    public List<Produto> findAll() {
        return jpaProdutoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        jpaProdutoRepository.deleteById(id);
    }
}
