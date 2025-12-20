package com.pauloricardo.projetoservidorubuntu.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductsRequestDTO(

        @NotBlank(message = "Product Cannot Have An Empty Name")
        String name,

        @NotNull(message = "Quantity Is Obrigatory")
        Integer quantity,

        @Positive(message = "QThe Value Cannot Be Negative")
        Double price
) {

}
