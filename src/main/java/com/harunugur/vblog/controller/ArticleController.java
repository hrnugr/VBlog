package com.harunugur.vblog.controller;

import com.harunugur.vblog.dto.ArticleDto;
import com.harunugur.vblog.entity.Article;
import com.harunugur.vblog.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ArticleDto> save(@RequestBody ArticleDto articleDto){

        Article articleDB = articleService.save(convertToEntity(articleDto));

        return new ResponseEntity<>(convertToDto(articleDB), HttpStatus.CREATED);
    }

    private Article convertToEntity(ArticleDto articleDto){
        return modelMapper.map(articleDto,Article.class);
    }

    private ArticleDto convertToDto(Article article){
        return modelMapper.map(article,ArticleDto.class);
    }
}
