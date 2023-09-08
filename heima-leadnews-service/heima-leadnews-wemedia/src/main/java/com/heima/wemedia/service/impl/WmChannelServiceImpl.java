package com.heima.wemedia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.pojos.WmChannel;
import com.heima.wemedia.mapper.WmChannelmapper;
import com.heima.wemedia.service.WmChannelService;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @Date 2023/9/8 14:56
 * @Author pepedd864
 */
@Service
public class WmChannelServiceImpl extends ServiceImpl<WmChannelmapper, WmChannel> implements WmChannelService {

  /**
   * 查询所有自媒体频道
   *
   * @return
   */
  @Override
  public ResponseResult findAll() {
    return ResponseResult.okResult(list());
  }
}
