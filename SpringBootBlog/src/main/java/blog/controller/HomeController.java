package blog.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableAutoConfiguration
public class HomeController {

	@RequestMapping(path = { "/*", "/home" }, method = RequestMethod.GET)
	public String get() {
		return "index";
	}

	@RequestMapping(path = "/about", method = RequestMethod.GET)
	public String about() {
		return "about";
	}

}
