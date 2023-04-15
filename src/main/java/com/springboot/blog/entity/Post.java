package com.springboot.blog.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "posts", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String content;


    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true) //orphanRemover remove child if parent is removed
    // used set here instead of list because list allows duplicate but set does not
    private Set<Comment> comments = new HashSet<>();
}
