public class App {
    public static void main(String[] args) throws Exception {
        Pedido pedido1 = new Pedido(100, 1000f);
        
		PedidoFacade pedidoFacade = new PedidoFacade();
        pedidoFacade.realizarPedido(pedido1);

        PedidoFacadeProxy pedidoFacadeProxy = new PedidoFacadeProxy();
        pedidoFacadeProxy.realizarPedido(pedido1);
        
    }
}
