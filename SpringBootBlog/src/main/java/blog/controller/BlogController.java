package blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import blog.entity.Article;
import blog.service.ArticleService;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private ArticleService articleService;

	/*
	@RequestMapping(method = RequestMethod.GET)
	public String get(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size, Model model) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(page, size, sort);
		Page<Article> articles = articleService.findAllArticles(pageable);
		System.out.println(articles);
		model.addAttribute("articles", articles.getContent());
		return "blog";
	}
	*/
	@RequestMapping(value = "", method=RequestMethod.GET)
	public String getArticles(@PageableDefault(value = 15, sort = { "id" }, direction = Sort.Direction.DESC) 
	    Pageable pageable, Model model) {
	    List<Article> list = articleService.findAllArticles(pageable).getContent();
	    model.addAttribute("articles",list);
	    return "blog";
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String create() {
		return "/blog/create";
	}

}
