package com.loja.produto.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.loja.produto.model.Categoria;
import com.loja.produto.service.CategoriaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;



@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;

//	@ApiOperation("Endpoint responsável por buscar todos os Categorias")
//	@ApiResponses(value= {
//			@ApiResponse(code=200, message = "Consulta feita com sucesso"),
//			@ApiResponse(code=500, message = "Foi gerado um erro ao consultar os Categorias"),
//			@ApiResponse(code=404, message = "URL pesquisada não corresponde "),
//			@ApiResponse(code=403, message = "Você não tem permissão")
//})
	@Operation(
	        summary = "Endpoint issue",
	        description = "Descrição do endpoint",
	        responses = {
	                @ApiResponse(responseCode = "200", description = "Get realizado com sucesso."),
	                @ApiResponse(responseCode = "400", description = "Erro ao realizar o Get.")
	                }
	        )
	@CrossOrigin(origins = "*")
	@GetMapping
	public List<Categoria> obterTodos() {
		return categoriaService.obterTodos();
	}


//	@ApiOperation("Endpoint responsável por buscar um unico Categoria")
//	@ApiResponses(value= {
//			@ApiResponse(code=200, message = "Consulta feita com sucesso"),
//			@ApiResponse(code=500, message = "Foi gerado um erro ao consultar o Categoria"),
//			@ApiResponse(code=404, message = "URL pesquisada não corresponde "),
//			@ApiResponse(code=403, message = "Você não tem permissão")
//})
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public Optional<Categoria> obterporId(@PathVariable Long id) {
		return categoriaService.obterPorId(id);
	}

//	@ApiOperation("Endpoint responsável por adicionar um Categoria")
//	@ApiResponses(value= {
//				@ApiResponse(code=200, message = "Criou um Categoria"),
//				@ApiResponse(code=500, message = "Foi gerado um erro ao criar o Categoria"),
//				@ApiResponse(code=404, message = "URL pesquisada não corresponde "),
//				@ApiResponse(code=403, message = "Você não tem permissão")
//	})
	@CrossOrigin(origins = "*")
	@PostMapping
	public Categoria adicionar(@RequestBody @Valid Categoria categoria) {
		return categoriaService.adicionar(categoria);

	}

//	@ApiOperation("Endpoint responsável por deletar um Categoria")
//	@ApiResponses(value= {
//			@ApiResponse(code=200, message = "Categoria deletado com sucesso"),
//			@ApiResponse(code=500, message = "Foi gerado um erro ao deletar o Categoria"),
//			@ApiResponse(code=404, message = "URL pesquisada não corresponde "),
//			@ApiResponse(code=403, message = "Você não tem permissão")
//})
	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		categoriaService.deletar(id);
	}

//	@ApiOperation("Endpoint responsável para atualizar um Categoria")
//	@ApiResponses(value= {
//			@ApiResponse(code=200, message = "Categoria atualizado com sucesso"),
//			@ApiResponse(code=500, message = "Foi gerado um erro ao atualizar o Categoria"),
//			@ApiResponse(code=404, message = "URL pesquisada não corresponde "),
//			@ApiResponse(code=403, message = "Você não tem permissão")
//})
	@CrossOrigin(origins = "*")
	@PutMapping("/{id}")
	public Categoria atualizar(@PathVariable Long id, @Valid @RequestBody Categoria categoria) {
		return categoriaService.atualizar(id, categoria);

	}
}
