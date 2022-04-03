package br.com.abruno.client.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class CambioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal cotacaoCompra;
	private BigDecimal cotacaoVenda;
	private String dataHoraCotacao;

	public CambioDTO(BigDecimal cotacaoCompra, BigDecimal cotacaoVenda, String dataHoraCotacao) {
		super();
		this.cotacaoCompra = cotacaoCompra;
		this.cotacaoVenda = cotacaoVenda;
		this.dataHoraCotacao = dataHoraCotacao;
	}

	public BigDecimal getCotacaoCompra() {
		return cotacaoCompra;
	}

	public BigDecimal getCotacaoVenda() {
		return cotacaoVenda;
	}

	public String getDataHoraCotacao() {
		return dataHoraCotacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cotacaoCompra, cotacaoVenda, dataHoraCotacao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CambioDTO other = (CambioDTO) obj;
		return Objects.equals(cotacaoCompra, other.cotacaoCompra) && Objects.equals(cotacaoVenda, other.cotacaoVenda)
				&& Objects.equals(dataHoraCotacao, other.dataHoraCotacao);
	}

	@Override
	public String toString() {
		return "CambioDTO [cotacaoCompra=" + cotacaoCompra + ", cotacaoVenda=" + cotacaoVenda + ", dataHoraCotacao="
				+ dataHoraCotacao + "]";
	}

}
