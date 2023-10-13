package com.heima.model.article.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@TableName(value = "ap_article_content", autoResultMap = true)
public class ApArticleContent implements Serializable {

  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private Long id;

  /**
   * 文章id
   */
  @TableField("article_id")
  private Long articleId;

  /**
   * 文章内容
   */
  private String content;
}
