package com.heima.article;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.heima.article.mapper.ApArticleContentMapper;
import com.heima.article.service.ApArticleService;
import com.heima.file.service.FileStorageService;
import com.heima.model.article.pojos.ApArticle;
import com.heima.model.article.pojos.ApArticleContent;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;


/**
 * TODO
 *
 * @Date 2023/9/7 23:09
 * @Author pepedd864
 */
@SpringBootTest
public class ArticleTest {
  @Autowired
  private ApArticleContentMapper apArticleContentMapper;
  @Autowired
  private Configuration configuration;
  @Autowired
  private FileStorageService fileStorageService;
  @Autowired
  private ApArticleService apArticleService;

  @Test
  public void createStaticUrlTest() throws Exception {
    // 1.获取文章内容
    ApArticleContent apArticleContent = apArticleContentMapper
        .selectOne(
            Wrappers.<ApArticleContent>lambdaQuery()
                .eq(ApArticleContent::getArticleId, "1302977178887004162")
        );
    // 2.生成静态化文件
    Template template = configuration.getTemplate("article.ftl");
    Map<String, Object> content = new HashMap<>();
    content.put("content", JSONArray.parseArray(apArticleContent.getContent()));
    StringWriter out = new StringWriter();
    template.process(content, out);
    // 3.上传到minio
    InputStream in = new ByteArrayInputStream(out.toString().getBytes());
    String path = fileStorageService.uploadHtmlFile("", apArticleContent.getArticleId() + ".html", in);
    // 4. 更新文章的url
    apArticleService
        .update(
            Wrappers.<ApArticle>lambdaUpdate()
                .set(ApArticle::getStaticUrl, path)
                .eq(ApArticle::getId, apArticleContent.getArticleId())
        );
    System.out.println("上传成功：" + path);
  }
}
