package cn.kevenpotter.designpatterns.iterator.iterator01;

public interface IProject {

    // 增加项目
    void add(String name, int num, int cost);

    // 从老板这里看到的就是项目信息
    String getProjectInfo();

    // 获得一个可以被遍历的对象
    IProjectIterator iterator();
}
