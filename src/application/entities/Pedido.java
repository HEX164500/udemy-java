package application.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import application.entities.enuns.StatusPedido;

public class Pedido {
	private Integer ID;
	private Date momento;
	private Cliente cliente;
	private StatusPedido status;
	
	public Pedido() {
		
	}
	
	public Pedido(Integer id, Date momento, Cliente cliente, StatusPedido estado) {
		this.ID = id;
		this.momento = momento;
		this.cliente = cliente;
		this.status = estado;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("EE - dd / MM / yyyy - HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT-3"));
		return "ID: "  + this.ID + ", Data: " + sdf.format(this.momento) +
				", Proprietario: " + this.cliente.getName() + ", Estado: "  + status;
	}
}
