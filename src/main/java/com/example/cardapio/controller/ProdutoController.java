package com.example.cardapio.controller;

import com.example.cardapio.modal.Produto;
import com.example.cardapio.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;

    @GetMapping
    public List<Produto> getAll() {
        return repository.findAll();
    }



    @PostMapping
    public Produto addProduto(@RequestBody Produto param){
        return repository.save(param);
    }

}
