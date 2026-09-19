package model.servico;

public class ServicoDeSMSI {
    public void sendSMS(String mensagem, String destinatario) {
        System.out.println("Enviando SMS para " + destinatario + " : seu código é " + mensagem);
    }
}
