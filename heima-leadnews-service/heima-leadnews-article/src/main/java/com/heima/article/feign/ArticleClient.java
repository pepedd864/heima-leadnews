package com.heima.article.feign;

import com.heima.api.article.IArticleClient;
import com.heima.article.service.ApArticleService;
import com.heima.model.article.dtos.ArticleDto;
import com.heima.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @Date 2023/9/8 20:41
 * @Author pepedd864
 */
@RestController
public class ArticleClient implements IArticleClient {
  @Autowired
  private ApArticleService apArticleService;

  /**
   * 保存文章
   *
   * @param dto
   * @return
   */
  @PostMapping("/api/v1/article/save")
  @Override
  public ResponseResult saveArticle(ArticleDto dto) {
    return apArticleService.saveArticle(dto);
  }
}
