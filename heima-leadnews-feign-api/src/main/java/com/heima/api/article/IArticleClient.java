package com.heima.api.article;

import com.heima.model.article.dtos.ArticleDto;
import com.heima.model.common.dtos.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * TODO
 *
 * @Date 2023/9/8 20:35
 * @Author pepedd864
 */

@FeignClient("leadnews-article")
public interface IArticleClient {
  @PostMapping("/api/v1/article/save")
  ResponseResult saveArticle(@RequestBody ArticleDto dto);
}
