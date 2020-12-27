package com.harunugur.vblog.service;

import com.harunugur.vblog.entity.Category;
import com.harunugur.vblog.exceptions.NoRecordFoundException;
import com.harunugur.vblog.repository.CategoryRepository;
import com.harunugur.vblog.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PageUtil pageUtil;

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public void delete(Long id){
        categoryRepository.delete(findById(id));
    }

    public Category findById(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NoRecordFoundException("No Tag Founded!"));
        return category;
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Page<Category> findCategoryByPage(int page, int size, String sortDir, String sort ){
        PageRequest pageReq = pageUtil.page(page, size, sortDir, sort);
       return categoryRepository.findAll(pageReq);
    }

}
