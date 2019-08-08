package com.yqc.entity;

import lombok.Data;

/**
 * <p>title:</p> <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2017-11-01
 * @modified By yangqc
 */
@Data
public class ClassBean {

  public ClassBean(String name, String description) {
    this.name = name;
    this.description = description;
  }

  private int id;

  private String name;

  private String description;
}
