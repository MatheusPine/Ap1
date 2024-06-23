import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class CalculadoraITBI {

    public static void main(String[] args) {
        // Criando um objeto DecimalFormat para formatar os valores monetários
        DecimalFormat df = new DecimalFormat("#,##0.00");

        try {
            // Solicitando o valor de transação ao usuário
            String valorTransacaoStr = JOptionPane.showInputDialog("Digite o valor de transação do imóvel: R$");
            double valorTransacao = Double.parseDouble(valorTransacaoStr);

            // Validando se o valor de transação é positivo
            if (valorTransacao <= 0) {
                JOptionPane.showMessageDialog(null, "O valor de transação deve ser maior que zero.");
                return;
            }

            // Solicitando o valor venal ao usuário
            String valorVenalStr = JOptionPane.showInputDialog("Digite o valor venal do imóvel: R$");
            double valorVenal = Double.parseDouble(valorVenalStr);

            // Validando se o valor venal é positivo
            if (valorVenal <= 0) {
                JOptionPane.showMessageDialog(null, "O valor venal deve ser maior que zero.");
                return;
            }

            // Solicitando a porcentagem do imposto ITBI ao usuário
            String porcentagemITBIStr = JOptionPane.showInputDialog("Digite a porcentagem do imposto ITBI: ");
            double porcentagemITBI = Double.parseDouble(porcentagemITBIStr);

            // Validando se a porcentagem do imposto ITBI está no intervalo correto
            if (porcentagemITBI < 0 || porcentagemITBI > 100) {
                JOptionPane.showMessageDialog(null, "A porcentagem do imposto ITBI deve estar entre 0 e 100.");
                return;
            }

            // Calculando o valor base para o imposto (maior valor entre valor de transação e valor venal)
            double valorBase = Math.max(valorTransacao, valorVenal);

            // Calculando o valor do imposto ITBI
            double valorImpostoITBI = (valorBase * porcentagemITBI) / 100;

            // Exibindo o valor do imposto ITBI
            JOptionPane.showMessageDialog(null, "Valor do imposto ITBI: R$ " + df.format(valorImpostoITBI));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira valores numéricos válidos.");
        }
    }
}
