package com.pauloricardo.projetoservidorubuntu.Dtos;

public record ProductsResponseDTO(
        Long id,
        String name,
        Integer quantity,
        Double price
) {
}
