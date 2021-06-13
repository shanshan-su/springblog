package com.codeup.springblog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post findPostById(long id);

    Post findPostByTitle(String title);

//    Post create(String title, String body);
}
