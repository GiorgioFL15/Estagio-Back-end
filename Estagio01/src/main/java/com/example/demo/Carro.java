package com.example.demo;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class Carro {
	
	private String id;
	
	private String nome;
	private String marca;
	private String modelo;
	private String dataFabricacao;
	private Double preco;
	private String cor;
	
	public Carro() {}

	public Carro(
			String nome, 
			String marca, 
			String modelo, 
			String dataFabricacao, 
			Double preco, 
			String cor) {
		this.nome = nome;
		this.marca = marca;
		this.modelo = modelo;
		this.dataFabricacao = dataFabricacao;
		this.preco = preco;
		this.cor = cor;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}

	public String getMarca() {
		return marca;
	}
	public void setMarca(String novaMarca) {
		this.marca = novaMarca;
	}

	public String getModelo() {
		return modelo;
	}
	public void setModelo(String novoModelo) {
		this.modelo = novoModelo;
	}
	
	public String getData() {
		return dataFabricacao;
	}
	public void setData(String novaData) {
		this.dataFabricacao = novaData;
	}
	
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double novoPreco) {
		this.preco = novoPreco;
	}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String novaCor) {
		this.cor = novaCor;
	}
	
	public String getId() {
		return id;

	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Carro [id=" + id + ", nome=" + nome + ", marca=" + marca + ", modelo=" + modelo + ", dataFabricacao="
				+ dataFabricacao + ", preco=" + preco + ", cor=" + cor + "]";
	}
	
}

