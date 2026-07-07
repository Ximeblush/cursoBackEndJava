package com.techlab.ecommerce.exception;

public class ClienteExistenteException extends RuntimeException {
    public ClienteExistenteException(String mensaje) {
        super(mensaje);
    }
}
