package com.pauloricardo.projetoservidorubuntu.Controllers;

import com.pauloricardo.projetoservidorubuntu.Dtos.ProductsRequestDTO;
import com.pauloricardo.projetoservidorubuntu.Dtos.ProductsResponseDTO;
import com.pauloricardo.projetoservidorubuntu.Models.ProductsModel;
import com.pauloricardo.projetoservidorubuntu.Services.ProductsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    //Método para Testar a API
    @GetMapping("/test")
    public String test(){
        return "Test API OK";
    }

    //Método para crear Produtos
    @PostMapping("/create")
    public ResponseEntity<ProductsResponseDTO> create ( @RequestBody @Valid  ProductsRequestDTO dto){

       ProductsResponseDTO product = productsService.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    //Metodo para Listar todos os Produtos
    @GetMapping("/find")
    public ResponseEntity<List<ProductsResponseDTO>> findAll(){
        return ResponseEntity.ok(productsService.findAll());
    }

    //Metodo para Listar por ID
    @GetMapping("/find/{id}")
    public ResponseEntity<ProductsResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(productsService.findById(id));
    }

    //Metodo para Listar Parcialmente
    @GetMapping("search")
    public ResponseEntity<List<ProductsModel>> searchByName(
            @RequestParam String name
    ){
        return ResponseEntity.ok(productsService.findyByNameLike(name));
    }

    //Metodo para Atualizar os Produtos
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductsResponseDTO> update(
            @PathVariable Long id,
            @RequestBody @Valid ProductsRequestDTO dto){
        return ResponseEntity.ok(productsService.update(id,dto));
    }

    //Metodo para Deletar Produto
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        productsService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
