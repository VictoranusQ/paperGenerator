package com.vic;

import java.util.List;
import java.util.Scanner;

public class Login {

  public static Teacher login(List<Teacher> teachers) {
    /** @Author:VicHe
     *  @Description:登录模块，返回一个登陆成功的实例
     *  @Updatedate:2021/9/22
     */
    Teacher teacher = new Teacher();
    Scanner scan = new Scanner(System.in);
    while (true) {
      boolean isLogin = false; // 标记位，是否登录
      System.out.println("请输入用户名，密码，用空格分隔：");
      String tempUsername = scan.next();
      String tempPassword = scan.next();
      for (int i = 0; i < teachers.size(); i = i + 1) {
        Teacher checkTeacher = teachers.get(i); // 拿到当前遍历到的对象实例
        if (checkTeacher.getUsername().equals(tempUsername)
            && checkTeacher.getPassword().equals(tempPassword)) {
          teacher.setUsername(tempUsername);
          teacher.setPassword(tempPassword);
          teacher.setStage(checkTeacher.getStage());
          isLogin = true; // 登陆后跳出循环
          break;
        }
      }
      if (isLogin == false) { // 如果没有遍历到对应的用户
        System.out.println("请输入正确的用户名，密码！");
        continue;
      } else if (isLogin == true) {
        break;
      }
    }

    return teacher;
  }
}
