package com.loja.produto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja.produto.model.Categoria;
import com.loja.produto.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> obterTodos()
    {
        
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> obterPorId(Long id) {

        return categoriaRepository.findById(id);

    }
    
    
    public Categoria adicionar(Categoria categoria) {

    	categoria.setId(null);
        return categoriaRepository.save(categoria);

    }

    public void deletar(Long id) {
    	categoriaRepository.deleteById(id);
    }

    public Categoria atualizar(Long id, Categoria categoria) {
   
    	categoria.setId(id);
        return categoriaRepository.save(categoria);

    }
    
}
