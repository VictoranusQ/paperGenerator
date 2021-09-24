package com.vic;

import java.util.Scanner;

public class DemandChecker {
    public static boolean isDigit(String strNum) {
        /**
         * @Author:VicHe
         * @Description:判断一个字符串是否都为数字
         * @Updatedate:2021/9/22
         */
        return strNum.matches("[0-9]{1,}");
    }

    public static int checkDemand(int stage){
        /**
         * @Author:VicHe
         * @Description:检索输入模块，检索输入返回相应的信号量状态码，详见主函数注释
         * @Updatedate:2021/9/22
         */
        //根据登陆用户的stage给出如下输出
        if (stage == 8848){
            System.out.println("准备生成小学数学题目，请输入生成题目数量（输入-1将退出当前用户，重新登录）；");
            System.out.println("如需切换题目级别，请输入“切换为小学/初中/高中”；");
            System.out.println("如需生成题目，请直接输入生成题目数量（10~30道题目）；");
            System.out.println("请输入指令：");
        }else if (stage == 8849){
            System.out.println("准备生成初中数学题目，请输入生成题目数量（输入-1将退出当前用户，重新登录）；");
            System.out.println("如需切换题目级别，请输入“切换为小学/初中/高中”；");
            System.out.println("如需生成题目，请直接输入生成题目数量（10~30道题目）；");
            System.out.println("请输入指令：");
        }else if (stage == 8850){
            System.out.println("准备生成高中数学题目，请输入生成题目数量（输入-1将退出当前用户，重新登录）；");
            System.out.println("如需切换题目级别，请输入“切换为小学/初中/高中”；");
            System.out.println("如需生成题目，请直接输入生成题目数量（10~30道题目）；");
            System.out.println("请输入指令：");
        }
        int checkCode=404;//初始化信号为404
        Scanner scan =new Scanner(System.in);
        String demand = scan.next();
        while(true){
            if (demand.contains("切换为")){
                if (demand.equals("切换为小学")){
                    checkCode = 8848;
                    break;
                }else if (demand.equals("切换为初中")){
                    checkCode = 8849;
                    break;
                }else if (demand.equals("切换为高中")){
                    checkCode = 8850;
                    break;
                }else {
                    System.out.println("请输入小学、初中和高中三个选项中的一个!");
                    demand = scan.next();
                    continue;
                }
            } else if (demand.equals("-1")){
                checkCode = -1;
                break;
            } else if (isDigit(demand)){
                int taskNum = Integer.valueOf(demand);
                if (taskNum>=10&&taskNum<=30){
                    checkCode = taskNum;
                    break;
                }else {
                    System.out.println("请输入10-30的出题数！");
                    demand = scan.next();
                    continue;
                }
            }else {
                System.out.println("请按照输入规则输入！");
                demand = scan.next();
                continue;
            }
        }
        return checkCode;
    }
}
