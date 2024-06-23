import javax.swing.JOptionPane;

public class SistemaLogin {

    private static final String LOGIN_CORRETO = "AP1";
    private static final String SENHA_CORRETA = "Nota10";

    public static void main(String[] args) {
        int tentativas = 3;

        while (tentativas > 0) {
            // Solicitar login
            String login = JOptionPane.showInputDialog("Digite o login:");
            if (login == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário. Encerrando o programa.");
                System.exit(0);
            }

            // Solicitar senha
            String senha = JOptionPane.showInputDialog("Digite a senha:");
            if (senha == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário. Encerrando o programa.");
                System.exit(0);
            }

            // Verificar login e senha
            if (login.equals(LOGIN_CORRETO) && senha.equals(SENHA_CORRETA)) {
                JOptionPane.showMessageDialog(null, "Login bem-sucedido. Bem-vindo!");
                System.exit(0);
            } else {
                tentativas--;
                if (tentativas > 0) {
                    JOptionPane.showMessageDialog(null, 
                        "Login ou senha incorretos. Você tem " + tentativas + " tentativa(s) restante(s).");
                } else {
                    JOptionPane.showMessageDialog(null, 
                        "Login ou senha incorretos. Você esgotou suas tentativas. Acesso bloqueado.");
                }
            }
        }

        // Encerrar o programa após três tentativas falhas
        System.exit(0);
    }
}
