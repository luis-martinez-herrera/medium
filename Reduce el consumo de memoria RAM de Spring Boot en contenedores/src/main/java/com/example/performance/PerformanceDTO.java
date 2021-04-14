package com.example.performance;

import lombok.Data;

import java.io.Serializable;

@Data
public class PerformanceDTO implements Serializable {
    private static final long serialVersionUID = 8971707639540904580L;

    private Long id;
    private String content;
}
