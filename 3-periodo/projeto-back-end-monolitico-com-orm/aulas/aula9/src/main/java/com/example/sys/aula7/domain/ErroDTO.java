package com.example.sys.aula7.domain;

import java.time.LocalDateTime;

public class ErroDTO {
    private String mensagem;
    private LocalDateTime dataHora;

    public ErroDTO(String mensagem, LocalDateTime dataHora) {
        this.mensagem = mensagem;
        this.dataHora = dataHora;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
