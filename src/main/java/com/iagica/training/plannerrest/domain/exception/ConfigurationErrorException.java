package com.iagica.training.plannerrest.domain.exception;

public class ConfigurationErrorException extends RuntimeException {

    public ConfigurationErrorException(String keyValue) {
        super(String.format("Wrong configuration for key name: %s", keyValue));
    }
}
