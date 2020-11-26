package application;

import application.entities.Cliente;
import application.entities.Pedido;

public class Main {

	public static void main(String[] args) {
		Cliente cliente = new Cliente("Lucas Rafael", "1234567890", "email@email.com");
		Pedido pedido = new Pedido(0, cliente);
		
		System.out.println(pedido);

	}

}
