package com.example.orderservice.application;

import com.example.orderservice.domain.Pedido;
import com.example.orderservice.domain.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarPedidosPorUsuarioHandler {

    private final PedidoRepository pedidoRepository;

    public List<Pedido> handle(Long userId) {
        return pedidoRepository.findByUserId(userId);
    }
}
