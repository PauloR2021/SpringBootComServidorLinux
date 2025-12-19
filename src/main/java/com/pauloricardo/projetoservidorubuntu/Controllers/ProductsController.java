package com.pauloricardo.projetoservidorubuntu.Controllers;

import com.pauloricardo.projetoservidorubuntu.Services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/test")
    public String test(){
        return "Test API OK";
    }
}
