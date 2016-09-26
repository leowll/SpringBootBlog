package blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import blog.entity.Article;
import blog.entity.User;
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
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getArticles(@PageableDefault(value = 15, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable, Model model) {
		List<Article> list = articleService.findAllArticles(pageable).getContent();
		model.addAttribute("articles", list);
		return "blog";
	}

	@RequestMapping(path = "/{articleId}", method = RequestMethod.GET)
	public String getBlog(@PathVariable(value = "articleId") Long id, Model model) {
		Article article = articleService.findById(id);
		model.addAttribute("article", article);
		return "article";
	}

	@RequestMapping(path = "/{articleId}/edit", method = RequestMethod.GET)
	public String getEditBlog(@PathVariable(value = "articleId") Long id, Model model, WebRequest request) {
		Article article = articleService.findById(id);
		model.addAttribute("article", article);
		User user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
		if (user != null)
			return "edit";
		else
			return "login";
	}

	@RequestMapping(path = "/{articleId}/edit", method = RequestMethod.POST)
	public String editBlog(@PathVariable(value = "articleId") Long id, Model model, WebRequest request) {
		String title = request.getParameter("title");
		String article = request.getParameter("article");
		System.out.println("title:" + title + ",article:" + article);
		Article newArticle = new Article(title, article);
		newArticle.setId(id);
		articleService.save(newArticle);
		return "redirect:/blog/" + id;
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String create() {
		return "/blog/create";
	}

}
