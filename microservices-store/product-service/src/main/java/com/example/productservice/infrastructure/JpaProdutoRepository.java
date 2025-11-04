package com.example.productservice.infrastructure;

import com.example.productservice.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProdutoRepository extends JpaRepository<Produto, Long> {
}
