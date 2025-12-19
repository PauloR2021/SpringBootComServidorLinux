package com.pauloricardo.projetoservidorubuntu.Repositorys;

import com.pauloricardo.projetoservidorubuntu.Models.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsReposiory extends JpaRepository<ProductsModel, Long> {
}
