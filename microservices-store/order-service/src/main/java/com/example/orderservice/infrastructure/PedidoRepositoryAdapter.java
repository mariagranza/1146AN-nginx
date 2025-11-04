package com.example.orderservice.infrastructure;

import com.example.orderservice.domain.Pedido;
import com.example.orderservice.domain.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PedidoRepositoryAdapter implements PedidoRepository {

    private final JpaPedidoRepository jpaPedidoRepository;

    @Override
    public Pedido save(Pedido pedido) {
        return jpaPedidoRepository.save(pedido);
    }

    @Override
    public Optional<Pedido> findById(Long id) {
        return jpaPedidoRepository.findById(id);
    }

    @Override
    public List<Pedido> findByUserId(Long userId) {
        return jpaPedidoRepository.findByUserId(userId);
    }

    @Override
    public List<Pedido> findAll() {
        return jpaPedidoRepository.findAll();
    }
}
