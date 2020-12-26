package com.harunugur.vblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditableDto<U> {

    private U createdBy;
    private Date createdDate;
    private U lastModifiedBy;
    private Date lastModifiedDate;
}
