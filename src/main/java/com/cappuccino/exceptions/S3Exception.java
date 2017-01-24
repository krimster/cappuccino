package com.cappuccino.exceptions;

/**
 * Created by krime on 1/24/17.
 */
public class S3Exception extends RuntimeException {

    public S3Exception(Throwable e) {
        super(e);
    }

    public S3Exception(String s) {
        super(s);
    }
}
