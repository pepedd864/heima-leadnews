package com.heima.freemarker.controller;

import com.heima.freemarker.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * TODO
 *
 * @Date 2023/9/6 23:38
 * @Author pepedd864
 */

@Controller
public class HelloController {
  @GetMapping("/basic")
  public String hello(Model model) {
    model.addAttribute("name", "freemarker");
    Student stu = new Student();
    stu.setName("张三");
    stu.setAge(20);
    model.addAttribute("stu", stu);

    return "basic";
  }
}
