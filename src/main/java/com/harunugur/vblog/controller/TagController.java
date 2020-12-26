package com.harunugur.vblog.controller;

import com.harunugur.vblog.dto.TagDto;
import com.harunugur.vblog.entity.Tag;
import com.harunugur.vblog.service.TagService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<TagDto> save(@RequestBody TagDto tagDto){
        Tag tag = tagDtoToEntity(tagDto);
        Tag tagDB = tagService.save(tag);
        tagDto.setId(tagDB.getId());

        return ResponseEntity.ok(tagDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        tagService.delete(id);

        return new ResponseEntity<String>("Tag deleted succesfully.",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagDto> getTagById(@PathVariable Long id){
        Tag tagDB = tagService.findById(id);
        TagDto tagDto = convertToEntity(tagDB);
        return new ResponseEntity<TagDto>(tagDto, HttpStatus.OK);
    }

    @GetMapping("/pages")
    public ResponseEntity<List<TagDto>> getTag(@RequestParam(defaultValue = "0",required = false) int page,
                                               @RequestParam(defaultValue = "5",required = false) int size,
                                               @RequestParam(defaultValue = "DESC",required = false) String sortDir,
                                               @RequestParam(defaultValue = "id",required = false) String sort){
        List<Tag> tags = tagService.findByPage(page, size, sortDir, sort);
        List<TagDto> tagDtos = new ArrayList<>();
        for (Tag tag: tags) {
            tagDtos.add(convertToEntity(tag));
        }
        return new ResponseEntity<List<TagDto>>(tagDtos,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TagDto>> getAll(){
        List<Tag> tags = tagService.findAll();
        List<TagDto> tagDtos = new ArrayList<>();
        for (Tag tag: tags) {
            tagDtos.add(convertToEntity(tag));
        }

        return new ResponseEntity<List<TagDto>>(tagDtos,HttpStatus.OK);
    }

    private TagDto convertToEntity(Tag tag){
        return modelMapper.map(tag, TagDto.class);
    }

    private Tag tagDtoToEntity(TagDto tagDto) {
        Tag tag = modelMapper.map(tagDto, Tag.class);
        return tag;
    }
}
