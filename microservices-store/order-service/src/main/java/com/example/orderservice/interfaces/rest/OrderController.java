package com.example.orderservice.interfaces.rest;

import com.example.orderservice.application.CriarPedidoHandler;
import com.example.orderservice.application.ListarPedidosPorUsuarioHandler;
import com.example.orderservice.domain.Pedido;
import com.example.orderservice.interfaces.rest.dto.CriarPedidoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final CriarPedidoHandler criarPedidoHandler;
    private final ListarPedidosPorUsuarioHandler listarPedidosPorUsuarioHandler;

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody CriarPedidoRequest request) {
        Pedido novoPedido = criarPedidoHandler.handle(request);
        return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Pedido>> listarPedidosPorUsuario(@PathVariable Long userId) {
        List<Pedido> pedidos = listarPedidosPorUsuarioHandler.handle(userId);
        return ResponseEntity.ok(pedidos);
    }
}
