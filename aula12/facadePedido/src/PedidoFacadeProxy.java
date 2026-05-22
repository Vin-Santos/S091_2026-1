public class PedidoFacadeProxy implements PedidoInterface {
    private PedidoFacade pedidoFacade;
	private BancoDeDados bancoDados;

    public PedidoFacadeProxy() {
		pedidoFacade = new PedidoFacade();
		bancoDados = new BancoDeDados();
	}

    @Override
	public void realizarPedido(Pedido pedido) {
		bancoDados.abrirTransacao();
		pedidoFacade.realizarPedido(pedido);
		bancoDados.comitarTransacao();
	}
}
