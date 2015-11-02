/**
 * Copyright Céline Souchet
 */
package org.csouchet.gbsmith.error;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Souchet Celine
 *
 */
@RestController
public class ErrorController {

	@RequestMapping(path = "/error", produces = "application/json")
	@ResponseBody
	public Map<String, Object> handle(final HttpServletRequest request) {

		final Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", request.getAttribute("javax.servlet.error.status_code"));
		map.put("reason", request.getAttribute("javax.servlet.error.message"));

		return map;
	}
}
