package com.heima.model.user.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息
 *
 * @Date 2023/9/5 22:27
 * @Author pepedd864
 */
@Data
public class ApUserVO implements Serializable {
  private String name;
  private String image;
  private Boolean sex;
  private Short flag;
}
