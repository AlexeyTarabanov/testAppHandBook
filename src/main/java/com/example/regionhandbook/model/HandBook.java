package com.example.regionhandbook.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "handbooks")
public class HandBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "short_title")
    private String shortTitle;
}
