package model.servico;

public class ServicoDeNotificacao {
    private final ServicoDeEmail email;
    private final ServicoDeSMSI smsi;

    public ServicoDeNotificacao() {
        this.email = new ServicoDeEmail();
        this.smsi = new ServicoDeSMSI();
    }

    public void notificaPorEmail(String mensagem, String destinatario) {
        email.sendEmail(mensagem, destinatario);
    }

    public void notificaPorSMS(String mensagem, String destinatario) {
        smsi.sendSMS(mensagem, destinatario);
    }
}
