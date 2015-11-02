/**
 * Copyright Céline Souchet
 */
package org.csouchet.gbsmith;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author Souchet Celine
 */
public class ApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(final ServletContext container) throws ServletException {
		final ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet());
		registration.setLoadOnStartup(1);
		registration.addMapping("/user/*");
	}

}
