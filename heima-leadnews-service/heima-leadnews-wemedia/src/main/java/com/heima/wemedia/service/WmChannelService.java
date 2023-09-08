package com.heima.wemedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.pojos.WmChannel;

/**
 * TODO
 *
 * @Date 2023/9/8 14:55
 * @Author pepedd864
 */
public interface WmChannelService extends IService<WmChannel> {
  /**
   * 查询所有自媒体频道
   *
   * @return
   */
  ResponseResult findAll();
}
