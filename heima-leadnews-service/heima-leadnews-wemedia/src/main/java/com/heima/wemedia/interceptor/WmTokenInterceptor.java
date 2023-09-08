package com.heima.wemedia.interceptor;

import com.heima.model.wemedia.pojos.WmUser;
import com.heima.utils.thread.WmThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * 拦截器
 *
 * @Date 2023/9/8 8:40
 * @Author pepedd864
 */
@Slf4j
public class WmTokenInterceptor implements HandlerInterceptor {

  /**
   * 得到header中的userId，如果存在，存入thread local
   *
   * @param request
   * @param response
   * @param handler
   * @return
   * @throws Exception
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    String userId = request.getHeader("userId");
    Optional<String> optional = Optional.ofNullable(userId);
    if (optional.isPresent()) {
      //把用户id存入threadloacl中
      WmUser wmUser = new WmUser();
      wmUser.setId(Integer.valueOf(userId));
      WmThreadLocalUtil.setUser(wmUser);
      log.info("wmTokenFilter设置用户信息到threadlocal中...");
    }
    return true;
  }

  /**
   * 清理redis中的数据
   *
   * @param request
   * @param response
   * @param handler
   * @param modelAndView
   * @throws Exception
   */
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    log.info("清理threadlocal...");
    WmThreadLocalUtil.clear();
  }
}
