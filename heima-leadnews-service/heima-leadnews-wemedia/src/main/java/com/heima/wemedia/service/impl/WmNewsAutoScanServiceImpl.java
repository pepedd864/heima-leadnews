package com.heima.wemedia.service.impl;

import com.heima.model.wemedia.pojos.WmNews;
import com.heima.wemedia.service.WmNewsAutoScanService;
import com.heima.wemedia.service.WmNewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO
 *
 * @Date 2023/9/8 21:52
 * @Author pepedd864
 */
@Service
@Transactional
@Slf4j
public class WmNewsAutoScanServiceImpl implements WmNewsAutoScanService {
  @Autowired
  private WmNewsService wmNewsService;

  /**
   * 自媒体文章审核
   *
   * @param id
   */
  @Override
  public void autoScanWmNews(Integer id) {
    WmNews wmNews = wmNewsService.getById(id);
  }
}
