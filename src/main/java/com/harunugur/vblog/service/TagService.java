package com.harunugur.vblog.service;

import com.harunugur.vblog.utils.PageUtil;
import com.harunugur.vblog.entity.Tag;
import com.harunugur.vblog.exceptions.NoRecordFoundException;
import com.harunugur.vblog.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private  TagRepository tagRepository;

    @Autowired
    private PageUtil pageUtil;

    public Tag save(Tag tag){

       return tagRepository.save(tag);
    }

    public void delete(Long id){
        Tag tag = findById(id);
        tagRepository.delete(tag);
    }

    public Tag findById(Long id){
        Tag tag = tagRepository.findById(id).orElseThrow(()-> new NoRecordFoundException("No Tag Founded!"));
        return tag;
    }

    public List<Tag> findAll(){

        return tagRepository.findAll();
    }

    public List<Tag> findByPage(int page, int size, String sortDir, String sort) {
        PageRequest pageReq = pageUtil.page(page, size, sortDir, sort);
        Page<Tag> tags = tagRepository.findAll(pageReq);

        return tags.getContent();
    }

}
