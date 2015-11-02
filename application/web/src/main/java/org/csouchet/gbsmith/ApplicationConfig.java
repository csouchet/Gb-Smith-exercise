/**
 * Copyright Céline Souchet
 */
package org.csouchet.gbsmith;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

/**
 * @author Souchet Celine
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.csouchet.gbsmith")
public class ApplicationConfig extends WebMvcConfigurationSupport {

	@Override
	@Bean
	public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
		final RequestMappingHandlerAdapter handlerAdapter = super.requestMappingHandlerAdapter();
		// Configure to convert JSON to POJO and vice versa in the request and response
		handlerAdapter.getMessageConverters().add(0, new MappingJackson2HttpMessageConverter());
		return handlerAdapter;
	}
}
