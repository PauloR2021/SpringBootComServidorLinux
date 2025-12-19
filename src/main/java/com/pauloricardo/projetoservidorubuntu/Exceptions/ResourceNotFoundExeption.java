package com.pauloricardo.projetoservidorubuntu.Exceptions;

public class ResourceNotFoundExeption extends  RuntimeException {
    public ResourceNotFoundExeption(String msg){
        super(msg);
    }
}
