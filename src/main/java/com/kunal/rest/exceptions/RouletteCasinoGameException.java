/*
 * 
 */
package com.kunal.rest.exceptions;

/**
 * @author kunal
 */

public class RouletteCasinoGameException extends RuntimeException {

	public RouletteCasinoGameException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public RouletteCasinoGameException(final String message) {
		super(message);
	}
}
