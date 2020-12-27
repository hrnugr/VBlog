package com.harunugur.vblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    private Long id;
    private String title;
    private String content;
    private String summary;
    private Timestamp publishTime;
    private int status ;
    private boolean enabled;
    private Set<CategoryDto> categories;
    private Set<TagDto> tags;
}
