package com.yqc.entity;

import lombok.Data;

/**
 * user实体类
 *
 * @author yangqc
 */
@Data
public class UserBean {

  public UserBean(String name, String address, int age, ClassBean classBean) {
    this.name = name;
    this.address = address;
    this.age = age;
    this.classBean = classBean;
  }

  private int id;

  private String name;

  private String address;

  private int age;

  private ClassBean classBean;
}
