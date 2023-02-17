package com.loja.produto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.loja.produto.enums.EstadoProduto;

@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String patrimonio;
	
	@NotBlank
	@Column(nullable = false)
	private String codigo;
	
	@Column(nullable = false)
	private Double valor;
	
//	@Temporal(TemporalType.DATE)  
//	private Date dataCadastro = new Date(System.currentTimeMillis());
//	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@UpdateTimestamp
	private Date dataCadastro;
	
	@ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
	private Categoria categoria;

	@Enumerated(EnumType.STRING)
	@Column(name= "estado")
	private EstadoProduto estadoProduto;
	
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPatrimonio() {
		return patrimonio;
	}


	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	

	public Date getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public EstadoProduto getEstadoProduto() {
		return estadoProduto;
	}


	public void setEstadoProduto(EstadoProduto estadoProduto) {
		this.estadoProduto = estadoProduto;
	}
	
	@Transient
	@JsonFormat(pattern ="dd/MM/yyyy")
	public Date getDataFormatada(){
		return dataCadastro;
	}
	
}
	