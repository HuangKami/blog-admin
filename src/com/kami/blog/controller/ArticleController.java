package com.kami.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kami.blog.lucene.LuceneService;
import com.kami.blog.model.Article;
import com.kami.blog.model.DatatablesView;
import com.kami.blog.model.QueryCondition;
import com.kami.blog.quartz.ExecutorTask;
import com.kami.blog.service.ArticleService;


@Controller
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private LuceneService luceneService;
	
	@RequestMapping
	public String list() {
		return "article";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public DatatablesView<Article> list(Model model, QueryCondition queryCondition) {
		return articleService.getData(queryCondition, 0);
	}
	
	@RequestMapping("/delList")
	@ResponseBody
	public DatatablesView<Article> delList(Model model, QueryCondition queryCondition) {
		return articleService.getData(queryCondition, 1);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String updateDel(Article article) {
		articleService.updateNonEmptyArticleById(article);
		if(article.isDel()) {
			ExecutorTask.addTask(new Runnable() {
				@Override
				public void run() {
					luceneService.deleteIndex(article.getId());
				}
			});
		} else {
			ExecutorTask.addTask(new Runnable() {
				@Override
				public void run() {
					luceneService.createIndex(article);
				}
			});
		}
		return "success";
	}
}
