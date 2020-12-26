package com.harunugur.vblog.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class PageUtil {

    public PageRequest page(int page, int size, String sortDir, String sort){
        PageRequest pageReq = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);

        return pageReq;
    }
}
