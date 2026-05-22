public class ModuloEstoque {
	public void enviarPedido(Pedido pedido) {
		System.out.println("# Executando Modulo Estoque #");
		System.out.println("Enviando para o Estoque pedido Id: " +
				pedido.getId());
	}
}
