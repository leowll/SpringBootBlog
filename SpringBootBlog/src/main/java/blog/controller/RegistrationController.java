package blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "registration";
	}

}
