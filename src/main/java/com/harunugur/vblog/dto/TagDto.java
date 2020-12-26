package com.harunugur.vblog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TagDto {

    private Long id;
    private String name;
    private Timestamp createTime;
    private Timestamp updateTime;
}
