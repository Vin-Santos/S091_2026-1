
public class PizzaBuilder {
    private Pizza pizza;

    private PizzaBuilder() {
		pizza = new Pizza();
	}

    // Metodo mais importante para o padrao Builder
    public static PizzaBuilder builder() {
        return new PizzaBuilder();
    }

    public PizzaBuilder tamanho(Pizza.Tamanho t) {
		pizza.setTamanho(t);
		return this;
	}

	public PizzaBuilder sabor(Pizza.Sabor s) {
		pizza.setSabor(s);
		return this;
	}

	public PizzaBuilder comBorda() {
		pizza.setComBorda(true);
		return this;
	}
	public PizzaBuilder semBorda() {
		pizza.setComBorda(false);
		return this;
	}
	
    // Metodo final para o padrao Builder
	public Pizza obterPizza() {
		return pizza;
	}
}
