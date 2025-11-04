package com.example.orderservice.infrastructure;

import com.example.orderservice.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaPedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByUserId(Long userId);
}
