package com.harunugur.vblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String summary;
    private Timestamp publishTime;
    private Timestamp createdTime;
    private Timestamp updateTime;
    private int status ;
    private boolean enabled;

    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(
            name = "article_category",
            joinColumns = @JoinColumn(name = "article_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id",referencedColumnName = "id"))
    private Set<Category> categories = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "article_tag",
            joinColumns = @JoinColumn(name = "article_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id",referencedColumnName = "id"))
    private Set<Tag> tags = new HashSet<>();


}
