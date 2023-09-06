package com.heima.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.article.mapper.ApArticleMapper;
import com.heima.article.service.ApArticleService;
import com.heima.common.constants.ArticleConstants;
import com.heima.model.article.dtos.ArticleHomeDto;
import com.heima.model.article.pojos.ApArticle;
import com.heima.model.common.dtos.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @Date 2023/9/6 17:05
 * @Author pepedd864
 */
@Service
@Transactional
@Slf4j
public class ApArticleServiceImpl extends ServiceImpl<ApArticleMapper, ApArticle> implements ApArticleService {

  @Autowired
  private ApArticleMapper apArticleMapper;

  /**
   * 加载文章列表
   *
   * @param dto
   * @param type 1: 加载更多 2：加载最新
   * @return
   */
  @Override
  public ResponseResult load(ArticleHomeDto dto, Short type) {
    // 1. 校验参数
    // 1.1 分页条数的校验
    Integer size = dto.getSize();
    if (size == null || size <= 0) {
      size = 10;
    }
    // 最大不超过50
    size = Math.min(size, 50);
    // 1.2 校验type
    if (!type.equals(ArticleConstants.LOADTYPE_LOAD_MORE) && !type.equals(ArticleConstants.LOADTYPE_LOAD_NEW)) {
      type = ArticleConstants.LOADTYPE_LOAD_MORE;
    }
    // 1.3 校验频道
    if (StringUtils.isEmpty(dto.getTag())) {
      dto.setTag(ArticleConstants.DEFAULT_TAG);
    }
    // 1.4 校验时间
    if (dto.getMaxBehotTime() == null) dto.setMaxBehotTime(new Date());
    if (dto.getMinBehotTime() == null) dto.setMinBehotTime(new Date());

    // 2. 查询
    List<ApArticle> apArticleList = apArticleMapper.loadArticleList(dto, type);
    // 3. 封装结果
    return ResponseResult.okResult(apArticleList);
  }
}
