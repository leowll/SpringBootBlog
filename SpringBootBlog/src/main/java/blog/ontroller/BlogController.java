package blog.ontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String get() {
		return "blogs";
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String create() {
		return "/blog/create";
	}

}
