package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/user")
public class UserController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String get() {
		return "get user";
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String create() {
		return "/user";
	}
}
