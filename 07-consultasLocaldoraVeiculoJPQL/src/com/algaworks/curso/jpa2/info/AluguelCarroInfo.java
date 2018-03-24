package com.algaworks.curso.jpa2.info;

import java.math.BigDecimal;

import com.algaworks.curso.jpa2.modelo.Carro;

public class AluguelCarroInfo {
	
	private Carro carro;
	private Long qtdAlugueis;
	private BigDecimal valorMaximo;
	private Double valorMedio;
	private BigDecimal valorMinimo;
	private BigDecimal soma;
	
	public AluguelCarroInfo (Carro carro, Long qtd, Number valorMaximo, Number valorMedio, Number valorMinimo, Number soma) {
		this.carro = carro;
		this.qtdAlugueis = qtd;
		this.valorMaximo = (BigDecimal) valorMaximo;
		this.valorMedio = (Double) valorMedio;
		this.valorMinimo = (BigDecimal) valorMinimo;
		this.soma = (BigDecimal) soma;
	}

	public AluguelCarroInfo() {
		super();
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Long getQtdAlugueis() {
		return qtdAlugueis;
	}

	public void setQtdAlugueis(Long qtdAlugueis) {
		this.qtdAlugueis = qtdAlugueis;
	}

	public BigDecimal getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(BigDecimal valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	public Double getValorMedio() {
		return valorMedio;
	}

	public void setValorMedio(Double valorMedio) {
		this.valorMedio = valorMedio;
	}

	public BigDecimal getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(BigDecimal valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public BigDecimal getSoma() {
		return soma;
	}

	public void setSoma(BigDecimal soma) {
		this.soma = soma;
	}

}
