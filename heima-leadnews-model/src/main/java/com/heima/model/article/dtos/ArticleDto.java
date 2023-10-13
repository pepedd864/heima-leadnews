package com.heima.model.article.dtos;

import com.heima.model.article.pojos.ApArticle;
import lombok.Builder;
import lombok.Data;

/**
 * TODO
 *
 * @Date 2023/9/8 20:38
 * @Author pepedd864
 */
@Data
@Builder
public class ArticleDto extends ApArticle {
  private String content;
}
