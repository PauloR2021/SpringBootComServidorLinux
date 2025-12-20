package com.pauloricardo.projetoservidorubuntu.Services;

import com.pauloricardo.projetoservidorubuntu.Dtos.ProductsRequestDTO;
import com.pauloricardo.projetoservidorubuntu.Dtos.ProductsResponseDTO;
import com.pauloricardo.projetoservidorubuntu.Models.ProductsModel;
import com.pauloricardo.projetoservidorubuntu.Repositorys.ProductsRepository;
import org.springframework.stereotype.Service;


@Service
public class ProductsService {

    //Chamando a Classe de Repositorio
    private ProductsRepository productsRepository;

    //Criando o Método de Criar Produtos
    public ProductsResponseDTO create(ProductsRequestDTO dto){
        ProductsModel products = new ProductsModel();
        products.setName(dto.name());
        products.setQuantity(dto.quantity());
        products.setPrice(dto.price());

        ProductsModel save = new ProductsModel();

        return new ProductsResponseDTO(
                save.getId(),
                save.getName(),
                save.getQuantity(),
                save.getPrice()
        );
    }




}
