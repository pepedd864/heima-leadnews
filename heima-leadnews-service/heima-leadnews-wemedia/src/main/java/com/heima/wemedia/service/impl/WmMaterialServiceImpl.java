package com.heima.wemedia.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.file.service.FileStorageService;
import com.heima.model.common.dtos.PageResponseResult;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.WmMaterialDto;
import com.heima.model.wemedia.pojos.WmMaterial;
import com.heima.model.wemedia.pojos.WmUser;
import com.heima.utils.thread.WmThreadLocalUtil;
import com.heima.wemedia.mapper.WmMaterialMapper;
import com.heima.wemedia.service.WmMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;

/**
 * TODO
 *
 * @Date 2023/9/8 9:19
 * @Author pepedd864
 */
@Service
@Transactional
public class WmMaterialServiceImpl extends ServiceImpl<WmMaterialMapper, WmMaterial> implements WmMaterialService {
  @Autowired
  private FileStorageService fileStorageService;

  /**
   * 上传图片
   *
   * @param multipartFile
   * @return
   */
  @Override
  public ResponseResult uploadPicture(MultipartFile multipartFile) {
    // 1.检查参数
    if (multipartFile == null || multipartFile.getSize() == 0) {
      return ResponseResult.errorResult(400, "上传图片为空");
    }
    // 2.上传图片
    String fileName = UUID.randomUUID().toString().replace("-", "");
    String originalFilename = multipartFile.getOriginalFilename();
    fileName += originalFilename.substring(originalFilename.lastIndexOf("."));
    String filePath = null;
    try {
      filePath = fileStorageService.uploadImgFile("", fileName, multipartFile.getInputStream());
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseResult.errorResult(400, "上传图片失败");
    }
    // 3.保存图片信息到数据库
    WmUser wmUser = WmThreadLocalUtil.getUser();
    WmMaterial wmMaterial = WmMaterial.builder()
        .userId(wmUser.getId())
        .url(filePath)
        .isCollection((short) 0)
        .type((short) 0)
        .createdTime(new Date())
        .build();
    save(wmMaterial);
    return ResponseResult.okResult(wmMaterial);
  }

  /**
   * 查询图片
   *
   * @param dto
   * @return
   */
  @Override
  public ResponseResult findList(WmMaterialDto dto) {
    // 1.检查参数
    dto.checkParam();
    // 2.分页查询
    IPage page = new Page(dto.getPage(), dto.getSize());
    LambdaQueryWrapper<WmMaterial> lambdaQueryWrapper = new LambdaQueryWrapper<>();
    // 3.查询条件
    // 是否收藏
    if (dto.getIsCollection() != null && dto.getIsCollection() == 1) {
      lambdaQueryWrapper.eq(WmMaterial::getIsCollection, dto.getIsCollection());
    }
    // 按照用户查询
    lambdaQueryWrapper.eq(WmMaterial::getUserId, WmThreadLocalUtil.getUser().getId());
    // 按时间倒叙
    lambdaQueryWrapper.orderByDesc(WmMaterial::getCreatedTime);
    // 4.执行查询
    page = page(page, lambdaQueryWrapper);
    // 5.返回结果
    ResponseResult responseResult = PageResponseResult.builder()
        .currentPage(dto.getPage())
        .size(dto.getSize())
        .total((int) page.getTotal())
        .build();
    responseResult.setData(page.getRecords());
    return responseResult;
  }
}
