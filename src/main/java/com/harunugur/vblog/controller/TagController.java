package com.harunugur.vblog.controller;

import com.harunugur.vblog.commons.DtoToEntity;
import com.harunugur.vblog.dto.TagDto;
import com.harunugur.vblog.entity.Tag;
import com.harunugur.vblog.service.TagService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @Autowired
    private DtoToEntity dtoToEntity;

    @PostMapping
    public ResponseEntity<TagDto> save(@RequestBody TagDto tagDto){
        Tag tag = dtoToEntity.tagDtoToEntity(tagDto);
        Tag tagDB = tagService.save(tag);
        tagDto.setId(tagDB.getId());

        return ResponseEntity.ok(tagDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        tagService.delete(id);

        return new ResponseEntity<String>("Tag deleted succesfully.",HttpStatus.OK);
    }

}
