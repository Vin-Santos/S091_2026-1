
public class App {
    public static void main(String[] args) throws Exception {
        String salario = "Nome: John Smith, Salario: R$1000; Nome: John Doe, Salario: R$2000";

        DataSource dado_comp_encriptado = new CompressionDecorator(
                                            new EncryptionDecorator(
                                                new FileDataSource("OutputDemo.txt")));

        DataSource dado_encriptado = new EncryptionDecorator(
                                            new FileDataSource("OutputDemo.txt"));

        dado_comp_encriptado.writeData(salario);
        DataSource arquivo_em_disco = new FileDataSource("OutputDemo.txt");

        System.out.println("- Entrada inicial ----------------");
        System.out.println(salario);

        System.out.println("- Dados comprimidos + encriptados lidos diretamente do disco  --------------");
        System.out.println(arquivo_em_disco.readData());

        System.out.println("- Dados comprimidos lidos diretamente do disco  --------------");
        System.out.println(dado_encriptado.readData());

        System.out.println("- Dados desencriptados --------------");
        System.out.println(dado_comp_encriptado.readData());
    }
}
