# paperGenerator 湖南大学个人项目

## 自动中小学生试卷生成器

本项目源码github仓库：[VictoranusQ/paperGenerator: 湖南大学个人项目——自动中小学试卷题目生成器 (github.com)](https://github.com/VictoranusQ/paperGenerator)

项目源码的缩进规范使用了idea自带的Google-java-format

![image-20210925215433544](C:\Users\VictoranusQ\AppData\Roaming\Typora\typora-user-images\image-20210925215433544.png)

**运行说明**

使用idea（建议）打开并运行main主类即可

**文件说明**

user.txt:类似数据库功能，存放已有的用户的用户名和密码，请把这个txt文件存放在你想要生成试卷文件夹的根目录下（默认为工程文件根目录，如果你想在别的目录生成试卷，请复制这个txt文件到相应目录）

如果你需要修改试卷存放路径：

需要修改源码Main类中第一个常量：

```java
public static final String DIR ="*****";
```

例如：需要在桌面生成试卷文件夹，DIR需修改成"C:\\Users\\YourUsername\\Desktop\\"，同时请复制user.txt文件到相应目录下



如果对源代码有改进意见可联系：mail 985619714@qq.com

