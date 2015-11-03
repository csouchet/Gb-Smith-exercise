/**
 * Copyright Céline Souchet
 */
package org.csouchet.gbsmith.user;

import javax.servlet.http.HttpServletResponse;

import org.csouchet.gbsmith.exception.CreateException;
import org.csouchet.gbsmith.exception.DeleteException;
import org.csouchet.gbsmith.exception.FindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Souchet Celine
 *
 */
@RestController
@RequestMapping(path = "/user", produces = "application/json")
@Transactional
public class UserController {

	@Autowired
	private UserService userService;

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(FindException.class)
	public void handleFindException(final FindException e) {
		// Nothing to do
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(DeleteException.class)
	public void handleDeleteException(final DeleteException e) {
		// Nothing to do
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(CreateException.class)
	public void handleCreateException(final CreateException e) {
		// Nothing to do
	}

	@RequestMapping(path="/{id}",method = RequestMethod.GET)
	public User getUser(@PathVariable final long id) throws FindException {
		final User user = userService.getUser(id);
		return user;
	}

	@RequestMapping(path="/{id}",method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable final long id, final HttpServletResponse response) throws DeleteException {
		userService.delete(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void createUser(@RequestParam("id") final long id, @RequestParam("firstname") final String firstname,
			@RequestParam("lastname") final String lastname, final HttpServletResponse response) throws CreateException {
		userService.create(id, firstname, lastname);
	}

}