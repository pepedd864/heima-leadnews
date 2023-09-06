package com.heima.model.article.dtos;

import lombok.Data;

import java.util.Date;

/**
 * TODO
 *
 * @Date 2023/9/6 16:06
 * @Author pepedd864
 */

@Data
public class ArticleHomeDto {
  // 最大时间
  Date maxBehotTime;
  // 最小时间
  Date minBehotTime;
  // 分页size
  Integer size;
  // 频道ID
  String tag;
}
