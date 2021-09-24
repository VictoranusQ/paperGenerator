package com.vic;

import java.util.Random;

public class TaskGenerator {
    public static String generateTask(int stage){
        /**
         * @Author:VicHe
         * @Description:出题模块，根据stage不同出相应难度的题目，8848：小学，8849：初中，8850：高中
         * @Updatedate:2021/9/22
         */
        String task = new String();
        if (stage == 8848){//小学题目
            task = "";
            String[] operators = new String[]{"+","-","*","/"};
            Random random = new Random();
            int digitNum = random.nextInt(3)+3;//数字个数随机在3-5个之间（也可以设置在0-5之间，下面加上了只有单个操作数时的判断，但有些单个数字的太简单了）
            String temp = new String();
            int operatorSelect;//运算符选择器
            int leftBracket = 0;//左括号个数
            int rightBracket = 0;//右括号个数
            for (int i =0;i<digitNum;i++){//对每一个操作数进行判断
                temp = "";
                String digit = Integer.toString(random.nextInt(100));//拿到这个随机的操作数
                if (digitNum <= 1){//如果操作数数量只有一个，直接接续
                    temp+=digit;
                } else if (i == 0){//如果是第一个操作数，只可能产生左括号
                    operatorSelect = random.nextInt(4);//选择跟随在这个操作数右边的操作符
                    int leftPossibility = random.nextInt(2);//0:不创建左括号 1：创建左括号，1/2可能性
                    if (leftPossibility == 0){//没有左括号
                        switch (operatorSelect){
                            case 0:
                                temp+=digit+"+";
                                break;
                            case 1:
                                temp+=digit+"-";
                                break;
                            case 2:
                                temp+=digit+"*";
                                break;
                            case 3:
                                temp+=digit+"/";
                                break;
                        }
                    }else if (leftPossibility == 1){//有左括号
                        leftBracket++;
                        switch (operatorSelect){
                            case 0:
                                temp+="("+digit+"+";
                                break;
                            case 1:
                                temp+="("+digit+"-";
                                break;
                            case 2:
                                temp+="("+digit+"*";
                                break;
                            case 3:
                                temp+="("+digit+"/";
                                break;
                        }
                    }
                }else if (i==digitNum-1){
                    if (leftBracket>rightBracket){
                        temp+=digit+")";
                    }else {
                        temp+=digit;
                    }
                }else {
                    if (leftBracket>rightBracket){//当左括号个数大于右括号个数的时候
                        operatorSelect = random.nextInt(4);
                        int rightPossibility = random.nextInt(2);//0:不创建右括号 1：创建右括号
                        if (rightPossibility == 0){
                            switch (operatorSelect){
                                case 0:
                                    temp+=digit+"+";
                                    break;
                                case 1:
                                    temp+=digit+"-";
                                    break;
                                case 2:
                                    temp+=digit+"*";
                                    break;
                                case 3:
                                    temp+=digit+"/";
                                    break;
                            }
                        }else if (rightPossibility == 1){
                            rightBracket++;
                            switch (operatorSelect){
                                case 0:
                                    temp+=digit+")"+"+";
                                    break;
                                case 1:
                                    temp+=digit+")"+"-";
                                    break;
                                case 2:
                                    temp+=digit+")"+"*";
                                    break;
                                case 3:
                                    temp+=digit+")"+"/";
                                    break;
                            }
                        }
                    }else {//当左括号个数不大于右括号个数的时候
                        operatorSelect = random.nextInt(4);
                        int leftPossibility = random.nextInt(2);//0:不创建左括号 1：创建左括号
                        if (leftPossibility == 0){
                            switch (operatorSelect){
                                case 0:
                                    temp+=digit+"+";
                                    break;
                                case 1:
                                    temp+=digit+"-";
                                    break;
                                case 2:
                                    temp+=digit+"*";
                                    break;
                                case 3:
                                    temp+=digit+"/";
                                    break;
                            }
                        }else if (leftPossibility == 1){
                            leftBracket++;
                            switch (operatorSelect){
                                case 0:
                                    temp+="("+digit+"+";
                                    break;
                                case 1:
                                    temp+="("+digit+"-";
                                    break;
                                case 2:
                                    temp+="("+digit+"*";
                                    break;
                                case 3:
                                    temp+="("+digit+"/";
                                    break;
                            }
                        }
                    }
                }
                task+=temp;
            }

        }
        else if (stage == 8849){//初中出题
            task = "";
            String[] priOperators = new String[]{"+","-","*","/"};
            String[] midOperators = new String[]{"√","^2"};
            Random random = new Random();
            int digitNum = random.nextInt(3)+3;//数字个数随机在3-5个之间（也可以设置在0-5之间，下面加上了只有单个操作数时的判断，但有些单个数字的太简单了）
            int midOpNum = 1;//中级运算符至少一个
            String temp = new String();
            int operatorSelect;//运算符选择器
            int leftBracket = 0;//左括号个数
            int rightBracket = 0;//右括号个数
            for (int i =0;i<digitNum;i++){//对每一个操作数进行判断
                temp = "";
                String digit = Integer.toString(random.nextInt(100));//拿到这个随机的操作数
                if (midOpNum>0){
                    int isUse = random.nextInt(2);//0:midOpNum不变   1:midOpNum-- 如此保证至少一个中级运算符
                    if (isUse == 1){
                        midOpNum --;
                    }
                    int midopSelect = random.nextInt(2);//0:√   1:^2
                    switch (midopSelect){
                        case 0:
                            digit = "√"+digit;
                            break;
                        case 1:
                            digit = digit + "^2";
                            break;
                    }
                }
                if (digitNum <= 1){//如果操作数数量只有一个，直接接续
                    temp+=digit;
                } else if (i == 0){//如果是第一个操作数，只可能产生左括号
                    operatorSelect = random.nextInt(4);//选择跟随在这个操作数右边的运算符
                    int leftPossibility = random.nextInt(2);//0:不创建左括号 1：创建左括号，1/2可能性
                    if (leftPossibility == 0){//没有左括号
                        switch (operatorSelect){
                            case 0:
                                temp+=digit+"+";
                                break;
                            case 1:
                                temp+=digit+"-";
                                break;
                            case 2:
                                temp+=digit+"*";
                                break;
                            case 3:
                                temp+=digit+"/";
                                break;
                        }
                    }else if (leftPossibility == 1){//有左括号
                        leftBracket++;
                        switch (operatorSelect){
                            case 0:
                                temp+="("+digit+"+";
                                break;
                            case 1:
                                temp+="("+digit+"-";
                                break;
                            case 2:
                                temp+="("+digit+"*";
                                break;
                            case 3:
                                temp+="("+digit+"/";
                                break;
                        }
                    }
                }else if (i==digitNum-1){
                    if (leftBracket>rightBracket){
                        temp+=digit+")";
                    }else {
                        temp+=digit;
                    }
                }else {
                    if (leftBracket>rightBracket){//当左括号个数大于右括号个数的时候
                        operatorSelect = random.nextInt(4);
                        int rightPossibility = random.nextInt(2);//0:不创建右括号 1：创建右括号
                        if (rightPossibility == 0){
                            switch (operatorSelect){
                                case 0:
                                    temp+=digit+"+";
                                    break;
                                case 1:
                                    temp+=digit+"-";
                                    break;
                                case 2:
                                    temp+=digit+"*";
                                    break;
                                case 3:
                                    temp+=digit+"/";
                                    break;
                            }
                        }else if (rightPossibility == 1){
                            rightBracket++;
                            switch (operatorSelect){
                                case 0:
                                    temp+=digit+")"+"+";
                                    break;
                                case 1:
                                    temp+=digit+")"+"-";
                                    break;
                                case 2:
                                    temp+=digit+")"+"*";
                                    break;
                                case 3:
                                    temp+=digit+")"+"/";
                                    break;
                            }
                        }
                    }else {//当左括号个数不大于右括号个数的时候
                        operatorSelect = random.nextInt(4);
                        int leftPossibility = random.nextInt(2);//0:不创建左括号 1：创建左括号
                        if (leftPossibility == 0){
                            switch (operatorSelect){
                                case 0:
                                    temp+=digit+"+";
                                    break;
                                case 1:
                                    temp+=digit+"-";
                                    break;
                                case 2:
                                    temp+=digit+"*";
                                    break;
                                case 3:
                                    temp+=digit+"/";
                                    break;
                            }
                        }else if (leftPossibility == 1){
                            leftBracket++;
                            switch (operatorSelect){
                                case 0:
                                    temp+="("+digit+"+";
                                    break;
                                case 1:
                                    temp+="("+digit+"-";
                                    break;
                                case 2:
                                    temp+="("+digit+"*";
                                    break;
                                case 3:
                                    temp+="("+digit+"/";
                                    break;
                            }
                        }
                    }
                }
                task+=temp;
            }
        }
        else if (stage == 8850){//高中出题
            task = "";
            String[] operators = new String[]{"+","-","*","/"};
            String[] adOperators = new String[]{"tan","sin","cos"};
            Random random = new Random();
            int digitNum = random.nextInt(3)+3;//数字个数随机在3-5个之间（也可以设置在0-5之间，下面加上了只有单个操作数时的判断，但有些单个数字的太简单了）
            int adOpNum = 1;//高级运算符至少一个
            String temp = new String();
            int operatorSelect;//运算符选择器
            int leftBracket = 0;//左括号个数
            int rightBracket = 0;//右括号个数
            for (int i =0;i<digitNum;i++){//对每一个操作数进行判断
                temp = "";
                String digit = Integer.toString(random.nextInt(100));//拿到这个随机的操作数
                if (adOpNum>0){
                    int isUse = random.nextInt(2);//0:adOpNum不变   1:adOpNum-- 如此保证至少一个中级运算符
                    if (isUse == 1){
                        adOpNum --;
                    }
                    int adopSelect = random.nextInt(3);//0:sin   1:cos   3:tan
                    switch (adopSelect){
                        case 0:
                            digit = "sin"+digit;
                            break;
                        case 1:
                            digit = "cos"+digit ;
                            break;
                        case 2:
                            digit = "tan"+digit ;
                            break;
                    }
                }
                if (digitNum <= 1){//如果操作数数量只有一个，直接接续
                    temp+=digit;
                } else if (i == 0){//如果是第一个操作数，只可能产生左括号
                    operatorSelect = random.nextInt(4);//选择跟随在这个操作数右边的操作符
                    int leftPossibility = random.nextInt(2);//0:不创建左括号 1：创建左括号，1/2可能性
                    if (leftPossibility == 0){//没有左括号
                        switch (operatorSelect){
                            case 0:
                                temp+=digit+"+";
                                break;
                            case 1:
                                temp+=digit+"-";
                                break;
                            case 2:
                                temp+=digit+"*";
                                break;
                            case 3:
                                temp+=digit+"/";
                                break;
                        }
                    }else if (leftPossibility == 1){//有左括号
                        leftBracket++;
                        switch (operatorSelect){
                            case 0:
                                temp+="("+digit+"+";
                                break;
                            case 1:
                                temp+="("+digit+"-";
                                break;
                            case 2:
                                temp+="("+digit+"*";
                                break;
                            case 3:
                                temp+="("+digit+"/";
                                break;
                        }
                    }
                }else if (i==digitNum-1){
                    if (leftBracket>rightBracket){
                        temp+=digit+")";
                    }else {
                        temp+=digit;
                    }
                }else {
                    if (leftBracket>rightBracket){//当左括号个数大于右括号个数的时候
                        operatorSelect = random.nextInt(4);
                        int rightPossibility = random.nextInt(2);//0:不创建右括号 1：创建右括号
                        if (rightPossibility == 0){
                            switch (operatorSelect){
                                case 0:
                                    temp+=digit+"+";
                                    break;
                                case 1:
                                    temp+=digit+"-";
                                    break;
                                case 2:
                                    temp+=digit+"*";
                                    break;
                                case 3:
                                    temp+=digit+"/";
                                    break;
                            }
                        }else if (rightPossibility == 1){
                            rightBracket++;
                            switch (operatorSelect){
                                case 0:
                                    temp+=digit+")"+"+";
                                    break;
                                case 1:
                                    temp+=digit+")"+"-";
                                    break;
                                case 2:
                                    temp+=digit+")"+"*";
                                    break;
                                case 3:
                                    temp+=digit+")"+"/";
                                    break;
                            }
                        }
                    }else {//当左括号个数不大于右括号个数的时候
                        operatorSelect = random.nextInt(4);
                        int leftPossibility = random.nextInt(2);//0:不创建左括号 1：创建左括号
                        if (leftPossibility == 0){
                            switch (operatorSelect){
                                case 0:
                                    temp+=digit+"+";
                                    break;
                                case 1:
                                    temp+=digit+"-";
                                    break;
                                case 2:
                                    temp+=digit+"*";
                                    break;
                                case 3:
                                    temp+=digit+"/";
                                    break;
                            }
                        }else if (leftPossibility == 1){
                            leftBracket++;
                            switch (operatorSelect){
                                case 0:
                                    temp+="("+digit+"+";
                                    break;
                                case 1:
                                    temp+="("+digit+"-";
                                    break;
                                case 2:
                                    temp+="("+digit+"*";
                                    break;
                                case 3:
                                    temp+="("+digit+"/";
                                    break;
                            }
                        }
                    }
                }

                task+=temp;
            }
        }
        task+="=";
        return task;
    }
}
