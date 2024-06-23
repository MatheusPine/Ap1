import javax.swing.JOptionPane;

public class CircuitoResistencias {

    public static void main(String[] args) {
        try {
            // Recebendo os valores das quatro resistências
            double r1 = lerResistencia("Digite o valor da primeira resistência:");
            double r2 = lerResistencia("Digite o valor da segunda resistência:");
            double r3 = lerResistencia("Digite o valor da terceira resistência:");
            double r4 = lerResistencia("Digite o valor da quarta resistência:");

            // Calculando a resistência equivalente
            double resistenciaEquivalente = calcularResistenciaEquivalente(r1, r2, r3, r4);

            // Determinando a maior e a menor resistência
            double maiorResistencia = calcularMaiorResistencia(r1, r2, r3, r4);
            double menorResistencia = calcularMenorResistencia(r1, r2, r3, r4);

            // Exibindo os resultados
            JOptionPane.showMessageDialog(null, 
                "Resistência Equivalente: " + resistenciaEquivalente + " ohms\n" +
                "Maior Resistência: " + maiorResistencia + " ohms\n" +
                "Menor Resistência: " + menorResistencia + " ohms");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um valor numérico válido.");
        }
    }

    // Método para ler o valor de uma resistência
    private static double lerResistencia(String mensagem) {
        String input = JOptionPane.showInputDialog(mensagem);
        if (input == null) { // Se o usuário cancelar a entrada
            JOptionPane.showMessageDialog(null, "Entrada cancelada. Encerrando o programa.");
            System.exit(0);
        }
        return Double.parseDouble(input.trim());
    }

    // Método para calcular a resistência equivalente
    private static double calcularResistenciaEquivalente(double r1, double r2, double r3, double r4) {
        return r1 + r2 + r3 + r4;
    }

    // Método para calcular a maior resistência
    private static double calcularMaiorResistencia(double r1, double r2, double r3, double r4) {
        return Math.max(Math.max(r1, r2), Math.max(r3, r4));
    }

    // Método para calcular a menor resistência
    private static double calcularMenorResistencia(double r1, double r2, double r3, double r4) {
        return Math.min(Math.min(r1, r2), Math.min(r3, r4));
    }
}
