package com.vic;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.HashSet;

public class PaperGenerator {

  public static void generatePaper(String username, int stage, int taskNum) {
    /**
     * @Author:VicHe
     * @Description:出卷模块，得到taskNum个题目编号序号传入文件命名为时间，存放在对应老师名字的文件夹下
     * @Updatedate:2021/9/22
     * 拿到以往所有题目的哈希表方便查重
     * 确定输出文件的名字（以时间命名），输出文件的路径
     * 进行文件的读取和编写：
     * 循环taskNum次：
     * 进入出题模块generateTask（参数stage），如果得到的题目没有在以往出现过（调用历史模块history（参数name）并查询是否有重复），
     * 则加入到新的题目list中
     */
    HashSet<String> historyTasks = History.history(username);
    String rootDir = Main.DIR + username + "\\";
    Calendar calendar = Calendar.getInstance();
    String year = Integer.toString(calendar.get(Calendar.YEAR));
    String month = Integer.toString(calendar.get(Calendar.MONTH) + 1);
    String day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
    String hour = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
    String minute = Integer.toString(calendar.get(Calendar.MINUTE));
    String second = Integer.toString(calendar.get(Calendar.SECOND));
    String paperStage = new String();
    switch (stage) {
      case 8848:
        paperStage = "小学-";
        break;
      case 8849:
        paperStage = "初中-";
        break;
      case 8850:
        paperStage = "高中-";
        break;
    }
    String papersDir =
        rootDir + paperStage + year + "-" + month + "-" + day + "-" + hour + "-" + minute + "-"
            + second + ".txt";
    try {
      FileOutputStream writerStream = new FileOutputStream(papersDir, true);
      BufferedWriter oWriter = new BufferedWriter(new OutputStreamWriter(writerStream, "UTF-8"));
      for (int i = 0; i < taskNum; i += 1) {
        while (true) {
          String taskEx = TaskGenerator.generateTask(stage);
          if (!historyTasks.contains(taskEx)) {
            taskEx = i + 1 + "." + " " + taskEx;
            oWriter.write(taskEx + "\n" + "\n");
            break;
          }
        }

      }
      oWriter.close();
      System.out.println("卷子生成完毕！");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
