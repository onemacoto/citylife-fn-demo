package com.citylife.function.api.demo.client.entity;

import java.io.Serializable;

public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  private long userid;

  private String account;

  private String password;

  private String username;

  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
