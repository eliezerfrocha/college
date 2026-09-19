package model;

import interfaces.Notificador;

public class SMSNotificador implements Notificador {
    @Override
    public void notificar(String mensagem, String destinatario) {
        System.out.println("Enviando SMS para " + destinatario + ": " + mensagem);
    }
}