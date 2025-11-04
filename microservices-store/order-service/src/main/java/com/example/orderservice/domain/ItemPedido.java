package com.example.orderservice.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "itens_pedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long produtoId; // Apenas o ID do produto, pois o serviço de produto é separado
    private String nomeProduto;
    private Double precoUnitario;
    private Integer quantidade;

    public ItemPedido(Long produtoId, String nomeProduto, Double precoUnitario, Integer quantidade) {
        this.produtoId = produtoId;
        this.nomeProduto = nomeProduto;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }
}
