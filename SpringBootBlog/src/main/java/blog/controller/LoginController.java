package blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import blog.entity.User;
import blog.service.UserService;

@Controller
@SessionAttributes("user")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String get() {
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, Model model, WebRequest request,SessionStatus status) {
		User user = new User();
		if (userService.isValidUser(username, password)) {
			model.addAttribute("user", user);
			return "redirect:blog";
		} else {
			request.removeAttribute("user", WebRequest.SCOPE_SESSION);
			model.addAttribute("error", "ログイン情報が不正です");
			return "login";
		}
	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout(Model model,  WebRequest request,SessionStatus status) {
		model.asMap().remove("user");
		request.removeAttribute("user", WebRequest.SCOPE_SESSION);
		return "redirect:home";
	}
}
