package com.heima.minio.test;

import com.heima.file.service.FileStorageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * TODO
 *
 * @Date 2023/9/7 14:28
 * @Author pepedd864
 */
@SpringBootTest
public class MinioTest {
  @Autowired
  private FileStorageService fileStorageService;

  @Test
  public void TestMinio() throws FileNotFoundException {
    FileInputStream inputStream = new FileInputStream("C:\\Users\\admin\\Desktop\\tmp\\pku-website\\public\\index.html");
    String filePath = fileStorageService.uploadHtmlFile("", "index.html", inputStream);
    System.out.println(filePath);
  }
}
