package com.pauloricardo.projetoservidorubuntu.Services;

import com.pauloricardo.projetoservidorubuntu.Dtos.ProductsRequestDTO;
import com.pauloricardo.projetoservidorubuntu.Dtos.ProductsResponseDTO;
import com.pauloricardo.projetoservidorubuntu.Exceptions.ResourceNotFoundExeption;
import com.pauloricardo.projetoservidorubuntu.Models.ProductsModel;
import com.pauloricardo.projetoservidorubuntu.Repositorys.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductsService {

    //Chamando a Classe de Repositorio
    @Autowired
    private ProductsRepository productsRepository;

    //Criando o Método de Criar Produtos
    public ProductsResponseDTO create(ProductsRequestDTO dto){

        ProductsModel products = new ProductsModel();
        products.setName(dto.name());
        products.setQuantity(dto.quantity());
        products.setPrice(dto.price());
        ProductsModel save = productsRepository.save(products);

       return new ProductsResponseDTO(
               save.getId(),
               save.getName(),
               save.getQuantity(),
               save.getPrice()
       );
    }

    //Criando o Método para Listar todos os Produtos
    public List<ProductsResponseDTO> findAll(){
        return productsRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    //Criando o Método para Listar por ID
    public ProductsResponseDTO findById(Long id){
        ProductsModel product = productsRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundExeption("Product Not Exists With The Id: " + id));

        return toResponseDTO(product);
    }

    //Criando o Método para Listar Parcialmente o Nome
    public List<ProductsModel> findyByNameLike(String name){
        List<ProductsModel> productsModels =
                productsRepository.findByNameContainingIgnoreCase(name);

        if(productsModels.isEmpty()){
            throw new ResourceNotFoundExeption(
                    "Product Not Exist With The Name: " +name );
        }
        return productsModels;
    }

    //Criando o Método para Update
    public ProductsResponseDTO update(Long id,ProductsRequestDTO dto){
        ProductsModel product = productsRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundExeption("Product Not Exists With The Id: "+id));

        product.setName(dto.name());
        product.setQuantity(dto.quantity());
        product.setPrice(dto.price());

        ProductsModel update = productsRepository.save(product);
        return toResponseDTO(update);
    }

    //Criando o Método de Delete
    public void delete(Long id){
        ProductsModel productsModel = productsRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundExeption("Product Not Exists With The Id: "+id)
                );

        productsRepository.delete(productsModel);
    }


    //Conversão Model -> DTO
    private ProductsResponseDTO toResponseDTO(ProductsModel products){
        return new ProductsResponseDTO(
                products.getId(),
                products.getName(),
                products.getQuantity(),
                products.getPrice()
        );

    }



}
