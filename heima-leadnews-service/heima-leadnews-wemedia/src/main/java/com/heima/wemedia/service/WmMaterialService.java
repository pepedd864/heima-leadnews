package com.heima.wemedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.WmMaterialDto;
import com.heima.model.wemedia.pojos.WmMaterial;
import org.springframework.web.multipart.MultipartFile;

/**
 * TODO
 *
 * @Date 2023/9/8 9:18
 * @Author pepedd864
 */
public interface WmMaterialService extends IService<WmMaterial> {
  /**
   * 上传图片
   *
   * @param multipartFile
   * @return
   */
  ResponseResult uploadPicture(MultipartFile multipartFile);

  /**
   * 查询图片
   *
   * @param dto
   * @return
   */

  ResponseResult findList(WmMaterialDto dto);
}
