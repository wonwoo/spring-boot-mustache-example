package me.wonwoo.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by wonwoolee on 2017. 4. 16..
 */
@Data
@Entity
public class Menu {

  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private String path;

  Menu() {

  }

  public Menu(String name, String path) {
    this.name = name;
    this.path = path;
  }

}
