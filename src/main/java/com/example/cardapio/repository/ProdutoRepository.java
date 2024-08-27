package com.example.cardapio.repository;

import com.example.cardapio.modal.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
