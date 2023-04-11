package com.saksoft.exception;

public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 3255533880139602854L;

    public ResourceNotFoundException(String msg){
        super(msg);
    }

}
