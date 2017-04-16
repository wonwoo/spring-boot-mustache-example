package me.wonwoo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by wonwoolee on 2017. 4. 16..
 */
@Controller
public class HomeController {

  @GetMapping("/")
  public String home(Model model) {
    return "index";
  }
}
