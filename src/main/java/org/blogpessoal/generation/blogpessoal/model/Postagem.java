package org.blogpessoal.generation.blogpessoal.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//para fazer virar uma tabela

@Entity
@Table(name="tb_postagens")
public class Postagem {
	
	//primary key
	@Id
	//auto_increment e decisão de como sera incrementado
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "O atributo titulo é obrigatorio!")
	@Size(min = 5, max = 100, message = "O atributo título deve conter no minimo 05 caracteres")
	public String titulo;
	@NotBlank(message = "O atributo texto é obrigatorio!")
	@Size(min = 10, max = 500, message = "O atributo título deve conter no minimo 05 caracteres")
	public String texto;
	@UpdateTimestamp
	public LocalDateTime date;
	
	@ManyToOne
	@JsonIgnoreProperties ("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
	
	

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
