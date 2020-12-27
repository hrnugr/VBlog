package com.harunugur.vblog.service;

import com.harunugur.vblog.entity.Article;
import com.harunugur.vblog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Article save(Article article){
        return articleRepository.save(article);
    }
}
