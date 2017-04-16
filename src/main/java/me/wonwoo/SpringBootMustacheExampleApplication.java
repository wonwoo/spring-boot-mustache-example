package me.wonwoo;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import me.wonwoo.repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.Writer;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootMustacheExampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootMustacheExampleApplication.class, args);
  }

  @Bean
  ApplicationRunner applicationRunner(MenuRepository menuRepository,
                                      AccountRepository accountRepository,
                                      PostRepository postRepository) {
    return args -> {
      Stream.of("HOME, /", "ACCOUNT, /accounts", "POST, /posts")
          .map(str -> str.split(","))
          .map(str -> new Menu(str[0], str[1]))
          .forEach(menuRepository::save);

      Stream.of("wonwoo, wonwoo@test.com", "seungwoo, seungwoo@test.com" ,"youngjin, youngjin@test.com")
          .map(str -> str.split(","))
          .map(str -> new Account(str[0], str[1]))
          .forEach(accountRepository::save);

      Stream.of("java example, <pre><code class=\"language-java\"><span class=\"hljs-function\"><span class=\"hljs-keyword\">public</span> <span class=\"hljs-keyword\">static</span> <span class=\"hljs-keyword\">void</span> <span class=\"hljs-title\">main</span><span class=\"hljs-params\">(String[] args)</span> </span>{\n" +
          "    System.out.println(<span class=\"hljs-string\">\"Hello world\"</span>);\n" +
          "}\n" +
          "</code></pre>", "scala example, <pre><code class=\"language-scala\"><span class=\"hljs-class\"><span class=\"hljs-keyword\">object</span> <span class=\"hljs-title\">HelloWorld</span> {</span>\n" +
          "  <span class=\"hljs-function\"><span class=\"hljs-keyword\">def</span> <span class=\"hljs-title\">main</span>(</span>args: <span class=\"hljs-type\">Array</span>[<span class=\"hljs-type\">String</span>]): <span class=\"hljs-type\">Unit</span> = {\n" +
          "    println(<span class=\"hljs-string\">\"Hello world!\"</span>)\n" +
          "  }\n" +
          "}\n" +
          "</code></pre>")
          .map(str -> str.split(","))
          .map(str -> new Post(str[0], str[1]))
          .forEach(postRepository::save);

    };
  }
}

