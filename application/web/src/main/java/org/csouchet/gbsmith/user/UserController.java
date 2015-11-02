/**
 * Copyright Céline Souchet
 */
package org.csouchet.gbsmith.user;

import javax.servlet.http.HttpServletResponse;

import org.csouchet.gbsmith.exception.FindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Souchet Celine
 *
 */
@RestController
@RequestMapping(path = "/user", produces = "application/json")
public class UserController {

	@Autowired
	private UserService userService;

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(FindException.class)
	public void handleFindException(final FindException e) {
		// Nothing to do
	}

	@RequestMapping(method = RequestMethod.GET)
	// @JsonView(User.class)
	public User getUser(@RequestParam("id") final long id) throws FindException {
		final User user = userService.getUser(id);
		return user;
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public String deleteUser(@RequestParam("id") final long id, final HttpServletResponse response) throws FindException {
		// final User user = userService.getUser(id);
		final boolean isDeleted = userService.delete(id);
		// model.addAttribute("user", isDeleted);
		//
		if (!isDeleted) {
			// will write which user couldn't be deleted
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			// model.addAttribute("user", user);
			return "user/error";
		}

		return "redirect:/user";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public String createUser(@RequestParam("id") final long id, @RequestParam("firstname") final String firstname,
			@RequestParam("lastname") final String lastname, final Model model, final HttpServletResponse response) throws FindException {
		final User user = userService.create(id, firstname, lastname);

		if (user == null) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "user/error";
		}
		model.addAttribute("user", user);
		return "redirect:/user";
	}

	// // Convert a predefined exception to an HTTP Status code
	// @ResponseStatus(value=HttpStatus.CONFLICT, reason="Data integrity violation") // 409
	// @ExceptionHandler(DataIntegrityViolationException.class)
	// public void conflict() {
	// // Nothing to do
	// }
	//
	// // Specify the name of a specific view that will be used to display the error:
	// @ExceptionHandler({SQLException.class,DataAccessException.class})
	// public String databaseError() {
	// // Nothing to do. Returns the logical view name of an error page, passed to
	// // the view-resolver(s) in usual way.
	// // Note that the exception is _not_ available to this view (it is not added to
	// // the model) but see "Extending ExceptionHandlerExceptionResolver" below.
	// return "databaseError";
	// }
	//
	// // Total control - setup a model and return the view name yourself. Or consider
	// // subclassing ExceptionHandlerExceptionResolver (see below).
	// @ExceptionHandler(Exception.class)
	// public ModelAndView handleError(HttpServletRequest req, Exception exception) {
	// logger.error("Request: " + req.getRequestURL() + " raised " + exception);
	//
	// ModelAndView mav = new ModelAndView();
	// mav.addObject("exception", exception);
	// mav.addObject("url", req.getRequestURL());
	// mav.setViewName("error");
	// return mav;
	// }

	//
	// @RequestMapping(path = "/owners/{ownerId}", method = RequestMethod.GET)
	// public String findOwner(@PathVariable final String ownerId, final Model model) {
	// final Owner owner = ownerService.findOwner(ownerId);
	// model.addAttribute("owner", owner);
	// return "displayOwner";
	// }
	//
	// @RequestMapping("/something")
	// public ResponseEntity<String> handle(final HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException
	// {
	// final String requestHeader = requestEntity.getHeaders().getFirst("MyRequestHeader");
	// final byte[] requestBody = requestEntity.getBody();
	//
	// // do something with request header and body
	//
	// final HttpHeaders responseHeaders = new HttpHeaders();
	// responseHeaders.set("MyResponseHeader", "MyValue");
	// return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
	// }
	//
	// @RequestMapping(method = RequestMethod.GET)
	// public String setupForm(@RequestParam("petId") final int petId, final ModelMap model) {
	// final Pet pet = clinic.loadPet(petId);
	// model.addAttribute("pet", pet);
	// return "petForm";
	// }
	//
	// @RequestMapping(method = RequestMethod.GET)
	// public Map<String, Appointment> get() {
	// return appointmentBook.getAppointmentsForToday();
	// }
	//
	// @RequestMapping(path = "/{day}", method = RequestMethod.GET)
	// public Map<String, Appointment> getForDay(@PathVariable @DateTimeFormat(iso = ISO.DATE) final Date day, final
	// Model model) {
	// return appointmentBook.getAppointmentsForDay(day);
	// }
	//
	// @RequestMapping(path = "/new", method = RequestMethod.GET)
	// public AppointmentForm getNewForm() {
	// return new AppointmentForm();
	// }
	//
	// @RequestMapping(method = RequestMethod.POST)
	// public String add(@Valid final AppointmentForm appointment, final BindingResult result) {
	// if (result.hasErrors()) {
	// return "appointments/new";
	// }
	// appointmentBook.addAppointment(appointment);
	// return "redirect:/appointments";
	// }
}
