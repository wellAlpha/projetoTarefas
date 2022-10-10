package com.devbackend.projeto.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Tarefa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotBlank
	@Column(nullable = false)
	private String titulo;
	@NotBlank
	@Column(nullable = false)
	private String descricao;
	@Column(nullable = false)
	private Boolean concluido;
	
	private String path;
	
	public Tarefa() {}
	
	public Tarefa(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
	}
	
	public Tarefa(Integer id, String titulo, String descricao, Boolean concluido) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.concluido = concluido;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		if (titulo != null && titulo.isEmpty())
		    this.titulo = null;
		  else
		    this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		if(descricao != null && descricao.isEmpty())
			this.descricao = null;
		else
			this.descricao = descricao;
	}

	public Boolean getConcluido() {
		return concluido;
	}

	public void setConcluido(Boolean concluido) {
		this.concluido = concluido;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
