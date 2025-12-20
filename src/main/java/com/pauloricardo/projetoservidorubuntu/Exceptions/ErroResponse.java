package com.pauloricardo.projetoservidorubuntu.Exceptions;

import java.time.LocalDateTime;

public class ErroResponse {

    //Função para Tratar os Erros de Resposta da API

    private int status;
    private String erro;
    private String message;
    private LocalDateTime timestamp;

    public ErroResponse(int status, String erro, String message) {
        this.status = status;
        this.erro = erro;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public int getStatus() {
        return status;
    }

    public String getErro() {
        return erro;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
