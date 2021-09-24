# paperGenerator 湖南大学个人项目

## 自动中小学生试卷生成器

读写文件的和输入检索的设计模块参考自CSDN博主HNUJSY：https://blog.csdn.net/HNUPCJ/article/details/109512724

**运行说明**

使用idea（建议）打开并运行main主类即可

**文件说明**

user.txt:类似数据库功能，存放已有的用户的用户名和密码，请把这个txt文件存放在你想要生成试卷文件夹的根目录下（默认为工程文件根目录）

如果你需要修改试卷存放路径：

需要修改源码Main类中第一个常量：

```java
public static final String DIR ="*****";
```

例如：需要在桌面生成试卷文件夹，DIR需修改成"C:\\Users\\YourUsername\\Desktop\\"



如果对源代码有改进意见可联系：mail 985619714@qq.com

