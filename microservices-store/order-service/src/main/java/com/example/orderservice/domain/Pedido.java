package com.example.orderservice.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // Apenas o ID do usuário, pois o serviço de usuário é separado

    private Double total;

    private Double frete;

    private String status = "Confirmado";

    private LocalDateTime dataPedido = LocalDateTime.now();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pedido_id")
    private List<ItemPedido> itens;

    public Pedido(Long userId, Double total, Double frete, List<ItemPedido> itens) {
        this.userId = userId;
        this.total = total;
        this.frete = frete;
        this.itens = itens;
    }

    public Double getSubtotal() {
        return total - frete;
    }
}
