/**
 * Copyright Céline Souchet
 */
package org.csouchet.gbsmith.user;

import org.csouchet.gbsmith.exception.CreateException;
import org.csouchet.gbsmith.exception.DeleteException;
import org.csouchet.gbsmith.exception.FindException;
import org.csouchet.gbsmith.persistence.SUser;
import org.csouchet.gbsmith.persistence.SUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Souchet Celine
 *
 */
@Service
public class UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private SUserRepository sUserRepository;

	public User create(final long id, final String firstname, final String lastname) throws CreateException {
		try {
			SUser sUser = new SUser(id, firstname, lastname);
			sUser = sUserRepository.save(sUser);
			return new UserBuilder(sUser).done();
		} catch (final Exception e) {
			LOGGER.error("Can't create a new user", e);
			throw new CreateException(e);
		}
	}

	public void delete(final long id) throws DeleteException {
		try {
			sUserRepository.delete(id);
		} catch (final Exception e) {
			LOGGER.error("Can't delete the user id=" + id, e);
			throw new DeleteException(e);
		}
	}

	public User getUser(final long id) throws FindException {
		try {
			final SUser sUser = sUserRepository.findOne(id);
			final UserBuilder builder = new UserBuilder(sUser);
			return builder.done();
		} catch (final Exception e) {
			LOGGER.error("Can't get the user id=" + id, e);
			throw new FindException(e);
		}
	}

}
