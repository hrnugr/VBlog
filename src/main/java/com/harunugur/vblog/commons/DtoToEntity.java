package com.harunugur.vblog.commons;

import com.harunugur.vblog.dto.TagDto;
import com.harunugur.vblog.entity.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DtoToEntity {

    @Autowired
    private ModelMapper modelMapper;

    public Tag tagDtoToEntity(TagDto tagDto) {
        Tag tag = modelMapper.map(tagDto, Tag.class);
        return tag;
    }
}
