import java.util.Scanner;
import java.text.DecimalFormat;

public class CalculadoraDesconto {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        DecimalFormat df = new DecimalFormat("#,##0.00");

        try {

            System.out.print("Digite o valor do produto: R$ ");
            double valorProduto = scanner.nextDouble();

            if (valorProduto <= 0) {
                System.out.println("O valor do produto deve ser maior que zero.");
                return;
            }

            System.out.print("Digite a porcentagem de desconto: ");
            double porcentagemDesconto = scanner.nextDouble();

            if (porcentagemDesconto < 0 || porcentagemDesconto > 100) {
                System.out.println("A porcentagem de desconto deve estar entre 0 e 100.");
                return;
            }

            double valorDesconto = (valorProduto * porcentagemDesconto) / 100;


            double precoFinal = valorProduto - valorDesconto;

            System.out.println("Valor do desconto: R$ " + df.format(valorDesconto));
            System.out.println("Preço final do produto: R$ " + df.format(precoFinal));

        } catch (Exception e) {
            System.out.println("Entrada inválida. Por favor, insira valores numéricos válidos.");
        } finally {
            
            scanner.close();
        }
    }
}
