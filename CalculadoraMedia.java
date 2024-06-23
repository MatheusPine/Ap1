import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class CalculadoraMedia {

    public static void main(String[] args) {
   
        DecimalFormat df = new DecimalFormat("#.##");

        try {

            double notaProva1 = lerNota("Digite a nota da primeira prova:");

            double notaProva2 = lerNota("Digite a nota da segunda prova:");

        
            double notaTrabalho = lerNota("Digite a nota do trabalho:");

            
            double media = calcularMedia(notaProva1, notaProva2, notaTrabalho);

           
            String status = media >= 6.0 ? "APROVADO" : "REPROVADO";

           
            JOptionPane.showMessageDialog(null, 
                    "Média: " + df.format(media) + "\nSituação: " + status);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite um número válido.");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário. Encerrando o programa.");
        }
    }

    
    private static double lerNota(String mensagem) {
        String input = JOptionPane.showInputDialog(mensagem);
        if (input == null) { 
            throw new NullPointerException();
        }
        return Double.parseDouble(input.trim());
    }

    private static double calcularMedia(double nota1, double nota2, double trabalho) {
    
        return (nota1 + nota2 + 2 * trabalho) / 4.0;
    }
}
