package com.example.orderservice.application;

import com.example.orderservice.domain.ItemPedido;
import com.example.orderservice.domain.Pedido;
import com.example.orderservice.domain.PedidoRepository;
import com.example.orderservice.interfaces.rest.dto.CriarPedidoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CriarPedidoHandler {

    private final PedidoRepository pedidoRepository;

    public Pedido handle(CriarPedidoRequest request) {
        List<ItemPedido> itens = request.getItens().stream()
                .map(itemDto -> new ItemPedido(
                        itemDto.getProdutoId(),
                        itemDto.getNomeProduto(),
                        itemDto.getPrecoUnitario(),
                        itemDto.getQuantidade()
                ))
                .collect(Collectors.toList());

        // Simulação de cálculo de total e frete
        double subtotal = itens.stream()
                .mapToDouble(item -> item.getPrecoUnitario() * item.getQuantidade())
                .sum();
        double frete = 20.0; // Valor fixo para simulação
        double total = subtotal + frete;

        Pedido novoPedido = new Pedido(
                request.getUserId(),
                total,
                frete,
                itens
        );

        return pedidoRepository.save(novoPedido);
    }
}
