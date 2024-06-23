import javax.swing.JOptionPane;

public class GeradorTabuada {

    public static void main(String[] args) {
        try {
            // Solicita ao usuário um número
            String input = JOptionPane.showInputDialog("Digite um número para gerar a tabuada:");
            if (input == null) { // Se o usuário cancelar a entrada
                JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário. Encerrando o programa.");
                System.exit(0);
            }

            int numero = Integer.parseInt(input.trim());

            // Gera a tabuada do número de 1 a 10
            StringBuilder tabuada = new StringBuilder();
            tabuada.append("Tabuada do ").append(numero).append(":\n");
            for (int i = 1; i <= 10; i++) {
                tabuada.append(numero).append(" x ").append(i).append(" = ").append(numero * i).append("\n");
            }

            // Exibe a tabuada
            JOptionPane.showMessageDialog(null, tabuada.toString());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
        }
    }
}
