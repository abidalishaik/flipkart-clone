package com.blogappapis.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResourseNotFoundException extends RuntimeException {
    private String resourseName;
    private String fieldname;
    private Long fieldValue;

    public ResourseNotFoundException(String resourseName, String fieldname, Long fieldValue) {
        super(String.format("%s not found with %s : %s", resourseName, fieldname, fieldValue));
        this.resourseName = resourseName;
        this.fieldname = fieldname;
        this.fieldValue = fieldValue;
    }
}
