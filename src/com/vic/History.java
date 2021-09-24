package com.vic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;

public class History {
  public static HashSet<String> history(String username) {
    /**
     * @Author:VicHe
     * @Description:历史模块，根据老师名字到相应目录下查找所有卷子，并将以往题目加到hash表中返回
     * @Updatedate:2021/9/22
     */
    HashSet<String> historyTasks = new HashSet<String>();
    String tasksDir = Main.DIR + username;
    File f = new File(tasksDir);
    if (!f.exists()) {
      f.mkdir();
    }
    File[] papers = f.listFiles();
    for (File paper : papers) {
      try {
        BufferedReader in = new BufferedReader(new FileReader(paper));
        String mytask;
        while ((mytask = in.readLine()) != null) {
          historyTasks.add(mytask);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return historyTasks;
  }
}
