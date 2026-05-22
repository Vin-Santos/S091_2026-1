public class ModuloPosVenda {
	public void agendarContatoCliente (Pedido pedido) {
		System.out.println("# Executando modulo ModuloPosVenda");
		System.out.println("Agendando contato"
				+ " cliente do pedido id " + pedido.getId());
	}
}
