package com.waiseer.communications.exception;

import org.springframework.http.HttpStatus;

public class ClientNotFoundException extends GeneralApiException{
    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public ClientNotFoundException(Long clientId) {

        super(String.format("Item with ID [%d] not found", clientId));
    }
}
