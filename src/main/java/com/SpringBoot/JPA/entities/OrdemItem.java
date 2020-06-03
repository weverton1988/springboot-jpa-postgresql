package com.SpringBoot.JPA.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.SpringBoot.JPA.entities.pk.OrdemItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_order_item")
public class OrdemItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrdemItemPK id = new OrdemItemPK();
	private Integer quantidade;
	private Double price;

	public OrdemItem () {
	}

	public OrdemItem(Order order, Produto produto, Integer quantidade, Double price) {
		super();
		id.setOrder(order);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.price = price;
	}
	
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}

	public void setOrder (Order order) {
		id.setOrder(order);
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}

	public void setProduto (Produto produto) {
		id.setProduto(produto);
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSubTotal() {
		return price * quantidade;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemItem other = (OrdemItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
