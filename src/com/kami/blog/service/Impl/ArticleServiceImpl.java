package com.kami.blog.service.Impl;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kami.blog.dao.ArticleDao;
import com.kami.blog.model.Article;
import com.kami.blog.model.DatatablesView;
import com.kami.blog.model.QueryCondition;
import com.kami.blog.common.Assist;
import com.kami.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private ArticleDao articleDao;
    @Override
    public long getArticleRowCount(Assist assist){
        return articleDao.getArticleRowCount(assist);
    }
    @Override
    public List<Article> selectArticle(Assist assist){
        return articleDao.selectArticle(assist);
    }
    @Override
    public Article selectArticleByObj(Article obj){
        return articleDao.selectArticleByObj(obj);
    }
    @Override
    public Article selectArticleById(Integer id){
        return articleDao.selectArticleById(id);
    }
    @Override
    public int insertArticle(Article value){
        return articleDao.insertArticle(value);
    }
    @Override
    public int insertNonEmptyArticle(Article value){
        return articleDao.insertNonEmptyArticle(value);
    }
    @Override
    public int insertArticleByBatch(List<Article> value){
        return articleDao.insertArticleByBatch(value);
    }
    @Override
    public int deleteArticleById(Integer id){
        return articleDao.deleteArticleById(id);
    }
    @Override
    public int deleteArticle(Assist assist){
        return articleDao.deleteArticle(assist);
    }
    @Override
    public int updateArticleById(Article enti){
        return articleDao.updateArticleById(enti);
    }
    @Override
    public int updateArticle(Article value, Assist assist){
        return articleDao.updateArticle(value,assist);
    }
    @Override
    public int updateNonEmptyArticleById(Article enti){
        return articleDao.updateNonEmptyArticleById(enti);
    }
    @Override
    public int updateNonEmptyArticle(Article value, Assist assist){
        return articleDao.updateNonEmptyArticle(value,assist);
    }

    public ArticleDao getArticleDao() {
        return this.articleDao;
    }

    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }
    
    @Override
    public String format(String content) {
    	Pattern pattern = Pattern.compile(">(.*?)<");
		Matcher matcher = pattern.matcher(content);
		StringBuilder sbBuilder = new StringBuilder();
		while(matcher.find()){
			sbBuilder.append(matcher.group().replaceAll(">", "").replaceAll("<", ""));
		}
		return sbBuilder.toString();
    }
    
    @Override
	public DatatablesView<Article> getData(QueryCondition queryCondition, int del) {
		DatatablesView<Article> datatablesView = new DatatablesView<>();
		Assist assist = new Assist();
		assist.setRequires(Assist.andEq("article.del", del));
		long recordsTotal = articleDao.getArticleRowCount(assist);
		assist.setStartRow(queryCondition.getStart())
				.setRowSize(queryCondition.getLength()).setOrder(Assist.order("article.id", true));
		if(queryCondition.getKeyword() != null && !queryCondition.getKeyword().equals("")) {
			assist.setRequires(Assist.andLike("title", "%" + queryCondition.getKeyword() + "%"));
		}
		
		List<Article> data = articleDao.selectArticle(assist);
		datatablesView.setRecordsTotal((int) recordsTotal);
		datatablesView.setData(data);
		return datatablesView;
	}

}