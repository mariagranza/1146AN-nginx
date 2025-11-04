package com.example.orderservice.domain;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository {
    Pedido save(Pedido pedido);
    Optional<Pedido> findById(Long id);
    List<Pedido> findByUserId(Long userId);
    List<Pedido> findAll();
}
