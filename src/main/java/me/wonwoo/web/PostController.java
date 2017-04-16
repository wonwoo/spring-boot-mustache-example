package me.wonwoo.web;

import me.wonwoo.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wonwoolee on 2017. 4. 16..
 */
@Controller
@RequestMapping("/posts")
public class PostController {
  private final PostRepository postRepository;

  public PostController(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @GetMapping
  public String posts(Model model) {
    model.addAttribute("posts" , postRepository.findAll());
    return "post";
  }
}
