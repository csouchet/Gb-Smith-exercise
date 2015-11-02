/**
 * Copyright Céline Souchet
 */
package org.csouchet.gbsmith.exception;

/**
 * @author Souchet Celine
 *
 */
public class FindException extends Exception {

	private static final long serialVersionUID = -2219100942226711770L;

	public FindException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public FindException(final Throwable cause) {
		super(cause);
	}

	public FindException(final String message) {
		super(message);
	}

}
