package com.vic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class InfoReader {
  public static List<Teacher> teachersInfo() {
    /**
     *  @Author:VicHe
     *  @Description:文件读取模块，将对应路径文件（类似数据库）中老师们信息读取并返回
     *  @Updatedate:2021/9/22 */
    List<Teacher> teachers = new ArrayList<Teacher>();
    File f = new File(Main.DIR + "user.txt");
    try {
      BufferedReader in = new BufferedReader(new FileReader(f));
      String teacherInfo;
      while ((teacherInfo = in.readLine()) != null) {
        String[] splitInfo = teacherInfo.split(" ");
        Teacher teacherTemp = new Teacher();
        teacherTemp.setUsername(splitInfo[0]);
        teacherTemp.setPassword(splitInfo[1]);
        if (splitInfo[2].equals("小学")) {
          teacherTemp.setStage(8848);
        } else if (splitInfo[2].equals("初中")) {
          teacherTemp.setStage(8849);
        } else if (splitInfo[2].equals("高中")) {
          teacherTemp.setStage(8850);
        }
        teachers.add(teacherTemp);
      }
      in.close();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

    return teachers;
  }
}
