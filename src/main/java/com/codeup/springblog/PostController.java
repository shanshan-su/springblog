package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String indexPage(Model model) {
        List<Post> posts = new ArrayList<>(Arrays.asList(
                new Post("My First Full Stack Application", "We were working on the project for about 4 days. And now it's nearly done!"),
                new Post("I don't like rain", "It's finally a sunny day today!!!"))
        );

        model.addAttribute("posts", posts);
        return "/posts/index";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String viewPost(@PathVariable int id, Model model) {
        Post post = new Post("My First Full Stack Application", "We were working on the project for about 4 days. And now it's nearly done!");
        model.addAttribute("post", post);
        return "/posts/show";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String getPostForm() {
        return "view the form for creating a post";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost() {
        return "create a new post";
    }

}
