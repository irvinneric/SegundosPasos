package com.tienda.exepciones;


public class CodigoInvalidoException extends Exception{
    public CodigoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
