package me.wonwoo.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Created by wonwoolee on 2017. 4. 16..
 */
@Data
@Entity
public class Post {

  @Id
  @GeneratedValue
  private Long id;

  private String title;

  @Lob
  private String content;

  Post() {

  }
  public Post(String title, String content){
    this.title = title;
    this.content = content;
  }
}
