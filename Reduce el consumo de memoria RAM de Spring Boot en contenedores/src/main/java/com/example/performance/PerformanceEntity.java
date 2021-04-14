package com.example.performance;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "demo")
public class PerformanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;

}
