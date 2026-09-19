package model;

import interfaces.Notificador;

public class NovoServicoDeNotificacao {
    private final Notificador notificadorEmail;
    private final Notificador notificadorSMS;

    public NovoServicoDeNotificacao(Notificador email, Notificador sms) {
        this.notificadorEmail = email;
        this.notificadorSMS = sms;
    }

    public void notificaPorEmail(String mensagem, String destinatario) {
        notificadorEmail.notificar(mensagem, destinatario);
    }

    public void notificaPorSMS(String mensagem, String destinatario) {
        notificadorSMS.notificar(mensagem, destinatario);
    }
}
