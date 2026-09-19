import model.servico.ServicoDeNotificacao;

public class App {
    public static void main(String[] args) {
        System.out.println();

        ServicoDeNotificacao notificacao = new ServicoDeNotificacao();
        // Enviando notificações
        notificacao.notificaPorEmail("xxx@sss.com", "FULANO");
        // Enviando SMS
        notificacao.notificaPorSMS("34533", "FULANO");
        
        System.out.println();
    }
}