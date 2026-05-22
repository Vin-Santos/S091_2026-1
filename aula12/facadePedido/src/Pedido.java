public class Pedido {
    private int id;
	private float valor;
	
	public Pedido(int id, float valor) {
		this.id = id;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", valor=" + valor + "]";
	}
}
