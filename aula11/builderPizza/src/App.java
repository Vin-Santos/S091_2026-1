public class App {
    public static void main(String[] args) throws Exception {
        
        Pizza pizza2 = PizzaBuilder.builder().semBorda().sabor(Pizza.Sabor.QuatroQueijos).tamanho(Pizza.Tamanho.Media).obterPizza();
		System.out.println(pizza2);

		Pizza pizza1 = PizzaBuilder
				.builder()
				.semBorda()
				.sabor(Pizza.Sabor.QuatroQueijos)
				.tamanho(Pizza.Tamanho.Media)
				.obterPizza();
		System.out.println(pizza1);

        PizzaBuilder pizzaB3 = PizzaBuilder.builder();
        pizzaB3 = pizzaB3.semBorda();
        pizzaB3 = pizzaB3.sabor(Pizza.Sabor.QuatroQueijos);
        pizzaB3 = pizzaB3.tamanho(Pizza.Tamanho.Media);
        Pizza pizza3 = pizzaB3.obterPizza();
		System.out.println(pizza3);

        PizzaBuilder pizzaB4 = PizzaBuilder.builder();
		System.out.println(pizzaB4.obterPizza());
        pizzaB4 = pizzaB4.semBorda();
		System.out.println(pizzaB4.obterPizza());
        pizzaB4 = pizzaB4.sabor(Pizza.Sabor.QuatroQueijos);
		System.out.println(pizzaB4.obterPizza());
        pizzaB4 = pizzaB4.tamanho(Pizza.Tamanho.Media);
		System.out.println(pizzaB4.obterPizza());
    }
}
