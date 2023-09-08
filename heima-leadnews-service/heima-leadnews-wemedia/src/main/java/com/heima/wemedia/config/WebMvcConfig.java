package com.heima.wemedia.config;

import com.heima.wemedia.interceptor.WmTokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * TODO
 *
 * @Date 2023/9/8 9:09
 * @Author pepedd864
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
  /**
   * @param registry
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new WmTokenInterceptor()).addPathPatterns("/**").excludePathPatterns("/*/login/*");
  }
}
