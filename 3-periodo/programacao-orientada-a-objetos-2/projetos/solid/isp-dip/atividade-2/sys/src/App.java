import interfaces.Notificador;

import model.EmailNotificador;
import model.NovoServicoDeNotificacao;
import model.SMSNotificador;

public class App {
    public static void main(String[] args) {
        System.out.println();
        Notificador emailNotificador = new EmailNotificador();
        Notificador smsNotificador = new SMSNotificador(); 

        NovoServicoDeNotificacao notificacao = new NovoServicoDeNotificacao(emailNotificador, smsNotificador);

        notificacao.notificaPorEmail("xxx@sss.com", "FULANO");
        notificacao.notificaPorSMS("34533", "FULANO");
        System.out.println();
    }
}