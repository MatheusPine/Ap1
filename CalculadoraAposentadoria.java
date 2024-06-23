import javax.swing.JOptionPane;

public class CalculadoraAposentadoria {

    public static void main(String[] args) {
        // Solicitando idade, sexo e anos de contribuição
        int idade = lerInteiro("Digite a idade:");
        char sexo = lerSexo();
        int anosContribuicao = lerInteiro("Digite os anos de contribuição:");

        // Verificando se pode se aposentar e calculando anos faltantes
        int anosFaltantes = calcularAnosFaltantes(idade, sexo, anosContribuicao);

        // Exibindo resultado
        if (anosFaltantes <= 0) {
            JOptionPane.showMessageDialog(null, "Você já pode se aposentar!");
        } else {
            JOptionPane.showMessageDialog(null, "Faltam " + anosFaltantes + " anos para você se aposentar.");
        }
    }

    // Método para ler um inteiro do usuário
    private static int lerInteiro(String mensagem) {
        String input = JOptionPane.showInputDialog(mensagem);
        return Integer.parseInt(input.trim());
    }

    // Método para ler o sexo do usuário
    private static char lerSexo() {
        String mensagem = "Digite o sexo (M ou F):";
        String input = JOptionPane.showInputDialog(mensagem).toUpperCase();
        return input.charAt(0);
    }

    // Método para calcular os anos faltantes para aposentadoria
    private static int calcularAnosFaltantes(int idade, char sexo, int anosContribuicao) {
        int anosFaltantes = 0;

        // Verificando se pode se aposentar por idade
        if (sexo == 'M') { // Homem
            if (idade >= 65) {
                anosFaltantes = 0;
            } else {
                anosFaltantes = 65 - idade;
            }
        } else if (sexo == 'F') { // Mulher
            if (idade >= 62) {
                anosFaltantes = 0;
            } else {
                anosFaltantes = 62 - idade;
            }
        }

        // Verificando se pode se aposentar por tempo de contribuição
        if (anosFaltantes > 0) {
            int idadeMinima = (sexo == 'M') ? 65 : 62;
            int anosMinimosContribuicao = 35;

            if (idade >= idadeMinima && anosContribuicao >= anosMinimosContribuicao) {
                anosFaltantes = 0;
            } else {
                anosFaltantes = Math.max(0, Math.max(idadeMinima - idade, anosMinimosContribuicao - anosContribuicao));
            }
        }

        return anosFaltantes;
    }
}
