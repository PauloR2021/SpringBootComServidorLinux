package com.pauloricardo.projetoservidorubuntu.Repositorys;

import com.pauloricardo.projetoservidorubuntu.Models.ProductsModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<ProductsModel, Long> {

    //Buscando por Nome Parcial utilizando o metodo Like
    List<ProductsModel> findByNameContainingIgnoreCase (String name);



}
