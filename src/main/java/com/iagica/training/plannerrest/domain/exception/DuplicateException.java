package com.iagica.training.plannerrest.domain.exception;

import jakarta.xml.bind.JAXBException;

public class DuplicateException extends JAXBException {
    /**
     * Construct a JAXBException with a linkedException.  The detail message and
     * vendor specific errorCode will default to null.
     *
     * @param message the linked exception
     */
    public DuplicateException(String message) {
        super(message);
    }
    public DuplicateException(Class<?> clazz, Long id) {
        super(String.format("Error for insert because Duplicate field : %s", clazz.getSimpleName(), id));
    }
    public DuplicateException(Class<?> clazz, String field) {
        super(String.format("Error for insert because Duplicate field : %s",field));
    }
}
