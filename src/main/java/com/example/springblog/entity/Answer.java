package com.example.springblog.entity;

import com.example.springblog.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime createDate;

    @ManyToOne
    private Question question;
    @ManyToOne
    private SiteUser author;
}
