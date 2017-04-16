package me.wonwoo.web;

import com.samskivert.mustache.Mustache;
import me.wonwoo.repository.Menu;
import me.wonwoo.repository.MenuRepository;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

/**
 * Created by wonwoolee on 2017. 4. 16..
 */
@ControllerAdvice
class MustacheAdvice {

  private final Mustache.Compiler compiler;
  private final MenuRepository menuRepository;

  public MustacheAdvice(Mustache.Compiler compiler, MenuRepository menuRepository) {
    this.compiler = compiler;
    this.menuRepository = menuRepository;
  }

  @ModelAttribute("menus")
  public List<Menu> menus() {
    return menuRepository.findAll();
  }

  @ModelAttribute("layout")
  public Mustache.Lambda layout(Map<String, Object> model) {
    return new Layout(compiler);
  }
}
