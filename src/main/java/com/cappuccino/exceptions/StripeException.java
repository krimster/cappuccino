package com.cappuccino.exceptions;

/**
 * Created by krime on 1/23/17.
 */
public class StripeException extends RuntimeException {

    public StripeException(Throwable e) {
        super(e);
    }
}
