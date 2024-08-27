package com.example.cardapio.controller;

import com.example.cardapio.modal.Produto;
import com.example.cardapio.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;


    @GetMapping
    public List<Produto> getAll() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Produto> getById(@PathVariable Long id){
        return repository.findById(id);
    }



    @PostMapping
    public Produto addProduto(@RequestBody Produto param){
        return repository.save(param);
    }




    @PutMapping("{id}")
    public Produto updateProduto(@PathVariable Long id, @RequestBody Produto param){

        Produto newProduto = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));

        newProduto.setTitulo(param.getTitulo());
        newProduto.setPreco(param.getPreco());
        newProduto.setImage(param.getImage());

        return  repository.save(newProduto);
    }



    @DeleteMapping("{id}")
    public void deleteProduto(@PathVariable Long id){
        repository.deleteById(id);
    }



}
