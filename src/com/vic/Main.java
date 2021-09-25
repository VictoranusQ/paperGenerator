package com.vic;

import java.util.List;

public class Main {

  public static final String DIR = System.getProperty("user.dir") + "\\"; // 当前项目的根目录

  public static void main(String[] args) {
    /**
     * @Author:VicHe
     * @Discription:主函数处理逻辑
     * @Updatedate: 2021/9/22
     * 从文件里读取老师信息：账号，密码，阶段（小学，初中，高中），赋值到Teacher实例list：teachers中
     * 进入登陆模块（参数为实例teachers），输入用户名密码，错误则重新输入 进入永真循环，检索输入后进行switch判断：
     * 检索输入模块checkDemand（参数为stage）：定义信号变量int checkCode，初始为404
     * 如果检索到“切换为”，则判断后续并返回为小学（checkCode=8848）/初中（8849）/高中（8850），若不符合则重新输入 如果检索到-1，则赋值checkCode后返回，
     * 如果检索到10-30的整数，则返回作为出题数量 定义外部变量checkCode接收输入模块checkDemand返回的int值 开始switch判断： case -1：重新进入登录模块
     * case 8848：更新当前用户的stage为8848 case 8849：更新当前用户的stage为8849 case 8850：更新当前用户的stage为8850
     * default：接收到了10-30的整数，作为参数传入出卷模块generatePaper（参数username，参数stage，参数checkCode）
     */
    List<Teacher> teachers = InfoReader.teachersInfo();
    Teacher teacher = Login.login(teachers);
    int stage = teacher.getStage();
    while (true) {
      int checkCode = DemandChecker.checkDemand(stage);
      switch (checkCode) {
        case -1:
          teacher = Login.login(teachers);
          stage = teacher.getStage();
          break;
        case 8848:
          stage = 8848; // 切换状态为小学
          break;
        case 8849:
          stage = 8849; // 切换状态为初中
          break;
        case 8850:
          stage = 8850; // 切换状态为高中
          break;
        default:
          PaperGenerator.generatePaper(teacher.getUsername(), stage, checkCode); // 调用出卷模块
          break;
      }
    }
  }
}
