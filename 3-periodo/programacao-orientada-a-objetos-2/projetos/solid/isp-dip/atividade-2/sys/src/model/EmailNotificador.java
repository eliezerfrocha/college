package model;

import interfaces.Notificador;

public class EmailNotificador implements Notificador {
    @Override
    public void notificar(String mensagem, String destinatario) {
        System.out.println("Enviando e-mail para " + destinatario + ": " + mensagem);
    }
}