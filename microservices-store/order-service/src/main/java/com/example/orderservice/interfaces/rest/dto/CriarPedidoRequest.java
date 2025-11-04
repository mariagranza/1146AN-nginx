package com.example.orderservice.interfaces.rest.dto;

import lombok.Data;

import java.util.List;

@Data
public class CriarPedidoRequest {
    private Long userId;
    private List<ItemPedidoDto> itens;

    @Data
    public static class ItemPedidoDto {
        private Long produtoId;
        private String nomeProduto;
        private Double precoUnitario;
        private Integer quantidade;
    }
}
