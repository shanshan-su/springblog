package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }


    @GetMapping(path = "/posts")
    public String indexPage(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String viewPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.findPostById(id));
        return "posts/show";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    public String getPostForm() {
        return "posts/create";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    public String create(@RequestParam String title, String body, Model model) {
        Post post = new Post(title, body);
        model.addAttribute("post", postDao.save(post));
        return "posts/show";
    }

    @GetMapping(path = "/posts/edit")
    public String editForm(@RequestParam long id, Model model) {
        model.addAttribute("post", postDao.findPostById(id));
        return "posts/edit";
    }

    @PostMapping(path = "/posts/edit")
    public String edit(@RequestParam long id, String title, String body, Model model) {
        Post post = new Post(id, title, body);
        model.addAttribute("post", postDao.saveAndFlush(post));
        return "posts/show";
    }

    @PostMapping(path = "/posts/delete")
    public String delete(@RequestParam long id, Model model) {
        postDao.deleteById(id);
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }


}
