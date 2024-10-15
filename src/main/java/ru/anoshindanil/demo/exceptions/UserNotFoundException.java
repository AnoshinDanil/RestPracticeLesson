package ru.anoshindanil.demo.exceptions;

public class UserNotFoundException extends  RuntimeException{

    private  String message = "User not found";

    public UserNotFoundException(String message) {
        super(message);
        this.message = message;

    }

    @Override
    public String getMessage() {
        return message;
    }

    public UserNotFoundException() {

    }
}
