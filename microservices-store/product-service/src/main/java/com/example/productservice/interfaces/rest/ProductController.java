package com.example.productservice.interfaces.rest;

import com.example.productservice.application.BuscarProdutoHandler;
import com.example.productservice.application.ListarProdutosHandler;
import com.example.productservice.domain.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ListarProdutosHandler listarProdutosHandler;
    private final BuscarProdutoHandler buscarProdutoHandler;

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        return ResponseEntity.ok(listarProdutosHandler.handle());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable Long id) {
        return buscarProdutoHandler.handle(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
