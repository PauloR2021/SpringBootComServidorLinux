package com.pauloricardo.projetoservidorubuntu.Dtos;

public record ProductsRequestDTO(
        String name,
        Integer quantity,
        Double price
) {

}
