package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "BLOG_POST")
@Data
public class BlogPost {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String text;
    private Date timestamp;
    
	@ManyToOne
	@JoinColumn(name = "FK_CATEGORY_ID")
    private Category category;
    
}
