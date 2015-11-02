/**
 * Copyright Céline Souchet
 */
package org.csouchet.gbsmith.exception;

/**
 * @author Souchet Celine
 *
 */
public class CreateException extends Exception {

	private static final long serialVersionUID = -3095520309744637364L;

	public CreateException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public CreateException(final String message) {
		super(message);
	}

	public CreateException(final Throwable cause) {
		super(cause);
	}

}
