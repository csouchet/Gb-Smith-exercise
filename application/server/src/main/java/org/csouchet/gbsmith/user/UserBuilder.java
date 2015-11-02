/**
 * Copyright Céline Souchet
 */
package org.csouchet.gbsmith.user;

import org.csouchet.gbsmith.persistence.SUser;

/**
 * @author Souchet Celine
 */
public class UserBuilder {

	private final User user = new User();

	public UserBuilder(final SUser sUser) {
		super();
		withId(sUser.getId()).withFirstName(sUser.getFirstName()).withLastName(sUser.getLastName());
	}

	public UserBuilder withId(final long id) {
		user.setId(id);
		return this;
	}

	public UserBuilder withFirstName(final String firstname) {
		user.setFirstName(firstname);
		return this;
	}

	public UserBuilder withLastName(final String lastname) {
		user.setLastName(lastname);
		return this;
	}

	public User done() {
		return user;
	}
}
