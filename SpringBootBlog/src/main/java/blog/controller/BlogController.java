package blog.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import blog.entity.Article;
import blog.entity.Comment;
import blog.entity.User;
import blog.service.ArticleService;
import blog.service.CommentService;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private CommentService commentService;

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
	public String getArticles(@RequestParam(value = "pageNo", required = false, defaultValue = "0") Integer pageNo,
			@PageableDefault(value = 5, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable, Model model) {
		Sort sort = new Sort(Direction.DESC, "id");
		pageable = new PageRequest(pageNo, 5, sort);
		Page<Article> articlePage = articleService.findAllArticles(pageable);
		List<Article> list = articlePage.getContent();
		int pageCnt = articlePage.getTotalPages();
		model.addAttribute("pageCnt", pageCnt);
		model.addAttribute("articles", list);
		return "blog";
	}

	@RequestMapping(path = "/new", method = RequestMethod.GET)
	public String getNewBlog(WebRequest request) {
		User user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
		if (user != null)
			return "new";
		else
			return "login";
	}

	@RequestMapping(path = "/new", method = RequestMethod.POST)
	public String postNewBlog(WebRequest request) {
		String title = request.getParameter("title");
		String articleContent = request.getParameter("article");
		Article newArticle = new Article(title, articleContent);
		User user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
		if (user != null) {
			articleService.save(newArticle);
			return "redirect:/blog";
		} else
			return "login";
	}

	@RequestMapping(path = "/{articleId}", method = RequestMethod.GET)
	public String getBlog(@PathVariable(value = "articleId") Long id, Model model,
			@PageableDefault(value = 10, sort = "createDate", direction = Sort.Direction.DESC) Pageable pageable) {
		Article article = articleService.findById(id);
		Page<Comment> commentPage = commentService.findByArticleId(id, pageable);
		List<Comment> comments = commentPage.getContent();
		model.addAttribute("article", article);
		model.addAttribute("comments", comments);
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

	@RequestMapping(path = "/{articleId}/delete", method = RequestMethod.POST)
	public String deleteBlog(@PathVariable(value = "articleId") Long id, Model model, WebRequest request) {
		Article article = articleService.findById(id);
		User user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
		if (user != null) {
			articleService.delete(article);
			return "redirect:/blog";
		} else
			return "login";
	}

	@RequestMapping(path = "/{articleId}/edit", method = RequestMethod.POST)
	public String editBlog(@PathVariable(value = "articleId") Long id, Model model, WebRequest request) {
		String title = request.getParameter("title");
		String article = request.getParameter("article");
		System.out.println("title:" + title + ",article:" + article);
		Article newArticle = new Article(title, article);
		newArticle.setId(id);
		articleService.update(newArticle);
		return "redirect:/blog/" + id;
	}

	@RequestMapping(path = "/{articleId}/comment", method = RequestMethod.POST)
	public String commentBlog(@PathVariable(value = "articleId") Long articleId, Model model, WebRequest request) {
		String content = request.getParameter("content");
		String username = request.getParameter("username");
		Comment comment = new Comment(articleId, username, content);
		commentService.saveOrUpdate(comment);
		return "redirect:/blog/" + articleId;
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String create() {
		return "/blog/create";
	}

}
