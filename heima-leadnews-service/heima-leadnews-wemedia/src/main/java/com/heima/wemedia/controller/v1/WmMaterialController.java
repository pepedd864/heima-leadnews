package com.heima.wemedia.controller.v1;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.WmMaterialDto;
import com.heima.wemedia.service.WmMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * TODO
 *
 * @Date 2023/9/8 9:12
 * @Author pepedd864
 */
@RestController
@RequestMapping("/api/v1/material")
public class WmMaterialController {
  @Autowired
  private WmMaterialService wmMaterialService;

  /**
   * 上传图片
   *
   * @param multipartFile
   * @return
   */

  @PostMapping("/upload_picture")
  public ResponseResult uploadPicture(MultipartFile multipartFile) {
    return wmMaterialService.uploadPicture(multipartFile);
  }

  /**
   * 查询图片
   *
   * @param dto
   * @return
   */
  @PostMapping("/list")
  public ResponseResult findList(@RequestBody WmMaterialDto dto) {
    return wmMaterialService.findList(dto);
  }
}
