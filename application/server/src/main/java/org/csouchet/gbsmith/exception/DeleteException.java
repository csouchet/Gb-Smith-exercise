/**
 * Copyright Céline Souchet
 */
package org.csouchet.gbsmith.exception;

/**
 * @author Souchet Celine
 *
 */
public class DeleteException extends Exception {

	private static final long serialVersionUID = -5932939919230308863L;

	public DeleteException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public DeleteException(final String message) {
		super(message);
	}

	public DeleteException(final Throwable cause) {
		super(cause);
	}

}
